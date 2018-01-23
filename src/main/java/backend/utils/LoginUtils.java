package backend.utils;

import backend.entities.UsersEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class LoginUtils {
    private static String hashPwd(String password, String salt) {
        String hashedPwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            byte byteData[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            hashedPwd = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPwd;
    }

    private static String getSalt() {
        Random r = new SecureRandom();
        byte[] bytes = new byte[32];
        r.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    @SuppressWarnings("unchecked")
    public static UsersEntity login(String login, String pwd) throws BadPasswordException {
        UsersEntity user = null;
        try (Session session = backend.utils.Connections.getSession()) {
            session.beginTransaction();
            Query q = session.createQuery("from UsersEntity as usr where usr.login=:Login");
            q.setParameter("Login", login);
            List<UsersEntity> users = q.list();
            if (users.size() == 1) {
                String actualPwd = users.get(0).getPassword();
                String triedPwd = hashPwd(pwd, users.get(0).getSalt());
                if (actualPwd.equals(triedPwd))
                    user = users.get(0);
                else {
                    throw new BadPasswordException();
                }
            }
        }
        return user;
    }

    public static UsersEntity register(String login, String pwd) throws BadPasswordException {
        UsersEntity user = login(login, pwd);
        if (user == null) {
            try (Session session = backend.utils.Connections.getSession()) {
                session.beginTransaction();
                user = new UsersEntity();
                user.setLogin(login);
                user.setSalt(getSalt());
                user.setPassword(hashPwd(pwd, user.getSalt()));
                user.setAccess(1);
                session.saveOrUpdate(user);
                session.getTransaction().commit();
            }
        } else {
            return null;
        }
        return user;
    }
}
