import backend.entities.DrugsEntity;
import backend.utils.CollisionData;
import backend.utils.DataUtils;

import java.util.List;

public class Testerino {
    public static void main(String[] args) {
        List<DrugsEntity> drugs = DataUtils.getDrugs();
        List<CollisionData> dupa = DataUtils.getCollisionData(drugs.get(0));
    }
}
