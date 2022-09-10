package Framework.Utils;

import java.io.File;

public class CreateReportFolder {

    public static void createReportFolder(String path){
        File pathReport = new File(path);
        if(!pathReport.exists()){
            pathReport.mkdir();
        }
    }

}
