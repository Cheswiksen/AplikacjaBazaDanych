import backend.entities.DrugsEntity;
import backend.utils.DataUtils;

import java.util.List;

public class Testerino {
    public static void main(String[] args){
        List<DrugsEntity> drugs=DataUtils.getDrugs();
        DataUtils.getCollisionData(drugs.get(0));
    }
}
