package org.jeecgframework.web.system.util;

import java.io.InputStream;

import com.aspose.cells.License;






public class LicenseUtil {
    /**
     * 获取license
     * 
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = LicenseUtil.class.getClassLoader().getResourceAsStream("\\license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
