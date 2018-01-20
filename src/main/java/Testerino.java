import backend.entities.DrugsEntity;
import backend.utils.DataUtils;

import java.util.List;

public class Testerino {
    public static void main(String[] args){
        List<DrugsEntity> drugs=DataUtils.getDrugs();
        List<DrugsEntity> dupa=drugs.subList(0,3);
        DataUtils.checkCollisions(dupa);
    }
}
