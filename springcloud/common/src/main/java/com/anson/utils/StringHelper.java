package com.anson.utils;

import java.text.SimpleDateFormat;
        import java.util.Date;

public class StringHelper
{

    /**
     * 默认的格式化方式
     */
    private static final String defaultFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String formatCurrentDate = dateFormat.format(currentDate).toString();

        return formatCurrentDate;
    }
}
//    /**
//     * 获取当前日期
//     * yyyy-MM-dd
//     * @return
//     */
//    public static String getCurrentDate() {
//        String format = "yyyy-MM-dd";
//        Date date = new Date();
//        date.setTime(System.currentTimeMillis());
//        if (format == null || "".equals(format.trim())) {
//            format = defaultFormat;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        return sdf.format(date);
//    }
//
//    /**
//     * 获取当前时间
//     * yyyyMMddHHmmss
//     * @return
//     */
//    public static String getCurrentTime() {
//        String format = "yyyyMMddHHmmss";
//        Date date = new Date();
//        date.setTime(System.currentTimeMillis());
//        if (format == null || "".equals(format.trim())) {
//            format = defaultFormat;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        return sdf.format(date);
//    }
//    /**
//     * 获取前一天日期yyyyMMdd
//     * @see 经测试，针对闰年02月份或跨年等情况，该代码仍有效。测试代码如下
//     * @see calendar.set(Calendar.YEAR, 2013);
//     * @see calendar.set(Calendar.MONTH, 0);
//     * @see calendar.set(Calendar.DATE, 1);
//     * @see 测试时，将其放到<code>calendar.add(Calendar.DATE, -1);</code>前面即可
//     * @return 返回的日期格式为yyyyMMdd
//     */
//    public static String getYestoday(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1);
//        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
//    }
//    /**
//     * 将日期格式转换成yyyy-MM-dd的字符串格式
//     * 返回值如：2010-10-06
//     * @param time 要转换的日期
//     * @return
//     */
//    public static  String dateToString(Date time)  {
//        SimpleDateFormat formatter = new  SimpleDateFormat ("yyyy-MM-dd"); //定义将日期格式要换成的格式
//        String stringTime  =  formatter.format(time);
//        return  stringTime;
//    }
//
//    /**
//     * 把html内容转为文本  --
//     * @param html
//     * @param filterTags
//     * @return
//     */
//    public static String trimHtml2Txt(String html, String[] filterTags){
//        html = html.replaceAll("\\<head>[\\s\\S]*?</head>(?i)", "");//去掉head
//        html = html.replaceAll("\\<!--[\\s\\S]*?-->", "");//去掉注释
//        html = html.replaceAll("\\<![\\s\\S]*?>", "");
//        html = html.replaceAll("\\<style[^>]*>[\\s\\S]*?</style>(?i)", "");//去掉样式
//        html = html.replaceAll("\\<script[^>]*>[\\s\\S]*?</script>(?i)", "");//去掉js
//        html = html.replaceAll("\\<w:[^>]+>[\\s\\S]*?</w:[^>]+>(?i)", "");//去掉word标签
//        html = html.replaceAll("\\<xml>[\\s\\S]*?</xml>(?i)", "");
//        html = html.replaceAll("\\<html[^>]*>|<body[^>]*>|</html>|</body>(?i)", "");
//        html = html.replaceAll("\\\r\n|\n|\r", " ");//去掉换行
//        html = html.replaceAll("\\<br[^>]*>(?i)", "\n\r");
//        List<String> tags = new ArrayList<String>();
//        List<String> s_tags = new ArrayList<String>();
//        List<String> halfTag = Arrays.asList(new String[]{"img","table","thead","th","tr","td"});//
//        if(filterTags != null && filterTags.length > 0){
//            for (String tag : filterTags) {
//                tags.add("<"+tag+(halfTag.contains(tag)?"":">"));//开始标签
//                if(!"img".equals(tag)) tags.add("</"+tag+">");//结束标签
//                s_tags.add("#REPLACETAG"+tag+(halfTag.contains(tag)?"":"REPLACETAG#"));//尽量替换为复杂一点的标记,以免与显示文本混合,如：文本中包含#td、#table等
//                if(!"img".equals(tag)) s_tags.add("#REPLACETAG/"+tag+"REPLACETAG#");
//            }
//        }
//        html = StringUtils.replaceEach(html, tags.toArray(new String[tags.size()]), s_tags.toArray(new String[s_tags.size()]));
//        html = html.replaceAll("\\</p>(?i)", "\n\r");
//        html = html.replaceAll("\\<[^>]+>", "");
//        html = StringUtils.replaceEach(html,s_tags.toArray(new String[s_tags.size()]),tags.toArray(new String[tags.size()]));
//        html = html.replaceAll("\\ ", " ");
//        return html.trim();
//    }
//    /**
//     * 将指定的文件夹复制到指定的路径地址
//     * @param dirPath 源文件-被复制的文件夹。
//     * @param sourcePath  目标文件--最终复制到的地址。
//     */
//    public static void copyFile(String dirPath,String sourcePath){
//
//        (new File(sourcePath)).mkdirs(); // 创建目标文件夹
//        File[] file = (new File(dirPath)).listFiles(); // 获取源文件夹当前下的文件或目录
//        for (int i = 0; i < file.length; i++) {
//            // 复制文件
//            try{
//                if (file[i].isFile()) {
//                    String type = file[i].getName().substring(file[i].getName().lastIndexOf(".") + 1);
//                    copyFile(file[i], new File(sourcePath + file[i].getName()));
//                }
//                // 复制目录
//                if (file[i].isDirectory()){
//                    String sourceDir = dirPath + File.separator + file[i].getName();
//                    String targetDir = sourcePath + File.separator + file[i].getName();
//                    copyDirectiory(sourceDir, targetDir);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//    // 复制文件
//    public static void copyFile(File sourceFile, File targetFile) throws IOException{
//        BufferedInputStream inBuff = null;
//        BufferedOutputStream outBuff = null;
//        try {
//            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
//            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
//            byte[] b = new byte[1024 * 5];
//            int len;
//            while ((len = inBuff.read(b)) != -1){
//                outBuff.write(b, 0, len);
//            }
//            outBuff.flush();
//        } finally {
//            if (inBuff != null)
//                inBuff.close();
//            if (outBuff != null)
//                outBuff.close();
//        }
//    }
//
//    // 复制文件夹
//    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException{
//        (new File(targetDir)).mkdirs();
//        File[] file = (new File(sourceDir)).listFiles();
//        for (int i = 0; i < file.length; i++){
//            if (file[i].isFile()){
//                File sourceFile = file[i];
//                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
//                copyFile(sourceFile, targetFile);//递归调用
//            }
//            if (file[i].isDirectory()){
//                String dir1 = sourceDir + "/" + file[i].getName();
//                String dir2 = targetDir + "/" + file[i].getName();
//                copyDirectiory(dir1, dir2);
//            }
//        }
//    }
//    /**
//     * 删除文件夹
//     * @param folderPath
//     */
//    public static void delFolder(String folderPath) {
//        try {
//            delAllFile(folderPath); //删除完里面所有内容
//            String filePath = folderPath;
//            filePath = filePath.toString();
//            java.io.File myFilePath = new java.io.File(filePath);
//            myFilePath.delete(); //删除空文件夹
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 删除指定文件夹下所有文件
//     * @param path 文件夹完整绝对路径 ,"Z:/xuyun/save"
//     */
//    public static boolean delAllFile(String path) {
//        boolean flag = false;
//        File file = new File(path);
//        if (!file.exists()) {
//            return flag;
//        }
//        if (!file.isDirectory()) {
//            return flag;
//        }
//        String[] tempList = file.list();
//        File temp = null;
//        for (int i = 0; i < tempList.length; i++) {
//            if (path.endsWith(File.separator)) {
//                temp = new File(path + tempList[i]);
//            } else {
//                temp = new File(path + File.separator + tempList[i]);
//            }
//            if (temp.isFile()) {
//                temp.delete();
//            }
//            if (temp.isDirectory()) {
//                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
//                delFolder(path + "/" + tempList[i]);//再删除空文件夹
//                flag = true;
//            }
//        }
//        return flag;
//    }
//
//    /**
//     * javaweb获取客户端IP
//     * @param request
//     * @return
//     */
//    public static String getIP(HttpServletRequest request){
//        String ip=request.getHeader("x-forwarded-for");
//        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
//            ip=request.getHeader("Proxy-Client-IP");
//        }
//        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
//            ip=request.getHeader("WL-Proxy-Client-IP");
//        }
//        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
//            ip=request.getHeader("X-Real-IP");
//        }
//        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
//            ip=request.getRemoteAddr();
//        }
//        return ip;
//    }
//
//    /**
//     *  任鸿伟 -- 2018/07/30
//     * 从Excel文件中读取数据
//     * @param file
//     * @throws Exception
//     */
//    public static List<List> getExcelData(File file) throws Exception{
//        FileInputStream in = new FileInputStream(file);
//        Workbook wb = null;
//        if(file.getName().endsWith("xls")){  //Excel 2003
//            wb = new HSSFWorkbook(in);
//        }else if(file.getName().endsWith("xlsx")){  // Excel 2007/2010
//            wb = new XSSFWorkbook(in);
//        }
//        int sheetCount = wb.getNumberOfSheets();
//        List<List> wbList = new ArrayList<List>();
//        for(int j=0;j<sheetCount;j++){//sheet
//            List<List> sheetList = new ArrayList<List>();
//            Sheet sheet = wb.getSheetAt(j);
//            int rowCount = sheet.getLastRowNum();
//            for(int i=0;i<=rowCount;i++){//row
//                List<String> rowList = new ArrayList<String>();
//                Row row = sheet.getRow(i);
//                if(row != null){
//                    int cellCount = row.getLastCellNum();
//                    for(int k=0;k<cellCount;k++){//cell
//                        Cell cell = row.getCell(k);
//                        if(cell != null){
//                            String value = "";
//                            switch(cell.getCellTypeEnum()) {
//                                case STRING:
//                                    value= cell.getStringCellValue();
//                                    break;
//                                case NUMERIC:
//                                    value=String.format("%.2f",cell.getNumericCellValue());
//                                    break;
//                                case BOOLEAN:
//                                    value=String.valueOf(cell.getBooleanCellValue());
//                                    break;
//                                case FORMULA:
//                                    value=String.valueOf(cell.getCellFormula());
//                                    break;
//                                case BLANK:
//                                    value="";
//                                    break;
//                                case ERROR:
//                                    value="";
//                                    break;
//                                default:
//                                    value="";
//                                    break;
//                            }
//                            rowList.add(value);
//                        }
//                    }
//                    sheetList.add(rowList);
//                }
//            }
//            wbList.add(sheetList);
//        }
//        return wbList;
//    }
//    /**
//     * 判断输入的字符串参数是否为空
//     * @return boolean 空则返回true,非空则flase
//     */
//    public static boolean isEmpty(String input) {
//        return null==input || 0==input.length() || 0==input.replaceAll("\\s", "").length();
//    }
//
//    /**
//     * 金额元转分
//     * @see 注意:该方法可处理贰仟万以内的金额,且若有小数位,则不限小数位的长度
//     * @see 注意:如果你的金额达到了贰仟万以上,则不推荐使用该方法,否则计算出来的结果会令人大吃一惊
//     * @param amount  金额的元进制字符串
//     * @return String 金额的分进制字符串
//     */
//    public static String moneyYuanToFen(String amount){
//        if(isEmpty(amount)){
//            return amount;
//        }
//        //传入的金额字符串代表的是一个整数
//        if(-1 == amount.indexOf(".")){
//            return Integer.parseInt(amount) * 100 + "";
//        }
//        //传入的金额字符串里面含小数点-->取小数点前面的字符串,并将之转换成单位为分的整数表示
//        int money_fen = Integer.parseInt(amount.substring(0, amount.indexOf("."))) * 100;
//        //取到小数点后面的字符串
//        String pointBehind = (amount.substring(amount.indexOf(".") + 1));
//        //amount=12.3
//        if(pointBehind.length() == 1){
//            return money_fen + Integer.parseInt(pointBehind)*10 + "";
//        }
//        //小数点后面的第一位字符串的整数表示
//        int pointString_1 = Integer.parseInt(pointBehind.substring(0, 1));
//        //小数点后面的第二位字符串的整数表示
//        int pointString_2 = Integer.parseInt(pointBehind.substring(1, 2));
//        //amount==12.03,amount=12.00,amount=12.30
//        if(pointString_1 == 0){
//            return money_fen + pointString_2 + "";
//        }else{
//            return money_fen + pointString_1*10 + pointString_2 + "";
//        }
//    }
//
//
//    /**
//     * 金额元转分
//     * @see 该方法会将金额中小数点后面的数值,四舍五入后只保留两位....如12.345-->12.35
//     * @see 注意:该方法可处理贰仟万以内的金额
//     * @see 注意:如果你的金额达到了贰仟万以上,则非常不建议使用该方法,否则计算出来的结果会令人大吃一惊
//     * @param amount  金额的元进制字符串
//     * @return String 金额的分进制字符串
//     */
//    public static String moneyYuanToFenByRound(String amount){
//        if(isEmpty(amount)){
//            return amount;
//        }
//        if(-1 == amount.indexOf(".")){
//            return Integer.parseInt(amount) * 100 + "";
//        }
//        int money_fen = Integer.parseInt(amount.substring(0, amount.indexOf("."))) * 100;
//        String pointBehind = (amount.substring(amount.indexOf(".") + 1));
//        if(pointBehind.length() == 1){
//            return money_fen + Integer.parseInt(pointBehind)*10 + "";
//        }
//        int pointString_1 = Integer.parseInt(pointBehind.substring(0, 1));
//        int pointString_2 = Integer.parseInt(pointBehind.substring(1, 2));
//        //下面这种方式用于处理pointBehind=245,286,295,298,995,998等需要四舍五入的情况
//        if(pointBehind.length() > 2){
//            int pointString_3 = Integer.parseInt(pointBehind.substring(2, 3));
//            if(pointString_3 >= 5){
//                if(pointString_2 == 9){
//                    if(pointString_1 == 9){
//                        money_fen = money_fen + 100;
//                        pointString_1 = 0;
//                        pointString_2 = 0;
//                    }else{
//                        pointString_1 = pointString_1 + 1;
//                        pointString_2 = 0;
//                    }
//                }else{
//                    pointString_2 = pointString_2 + 1;
//                }
//            }
//        }
//        if(pointString_1 == 0){
//            return money_fen + pointString_2 + "";
//        }else{
//            return money_fen + pointString_1*10 + pointString_2 + "";
//        }
//    }
//
//
//    /**
//     * 金额分转元
//     * @see 注意:如果传入的参数中含小数点,则直接原样返回
//     * @see 该方法返回的金额字符串格式为<code>00.00</code>,其整数位有且至少有一个,小数位有且长度固定为2
//     * @param amount  金额的分进制字符串
//     * @return String 金额的元进制字符串
//     */
//    public static String moneyFenToYuan(String amount){
//        if(isEmpty(amount)){
//            return amount;
//        }
//        if(amount.indexOf(".") > -1){
//            return amount;
//        }
//        if(amount.length() == 1){
//            return "0.0" + amount;
//        }else if(amount.length() == 2){
//            return "0." + amount;
//        }else{
//            return amount.substring(0, amount.length()-2) + "." + amount.substring(amount.length()-2);
//        }
//    }
//    /**
//     * 保存图片
//     *
//     */
//    public static synchronized void copy(File src, File newFile) {
//
//        try {
//            InputStream is = null;
//            OutputStream os = null;
//            try {
//                is = new BufferedInputStream(new FileInputStream(src),
//                        BUFFER_SIZE);
//                os = new BufferedOutputStream(new FileOutputStream(newFile),
//                        BUFFER_SIZE);
//                byte[] buffer = new byte[BUFFER_SIZE];
//                while (is.read(buffer) > 0) {
//                    os.write(buffer);
//                }
//            } finally {
//                if (null != is) {
//                    is.close();
//                }
//                if (null != os) {
//                    os.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 连接到指定的网站
//     *
//     */
//    public static String connect(String address){
//        HttpURLConnection conn = null;
//        URL url = null;
//        InputStream in = null;
//        BufferedReader reader = null;
//        StringBuffer stringBuffer = null;
//        try {
//            url = new URL(address);
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(5000);
//            conn.setReadTimeout(5000);
//            conn.setDoInput(true);
//            conn.connect();
//            in = conn.getInputStream();
//            reader = new BufferedReader(new  InputStreamReader(in,"gbk"));
//            stringBuffer = new StringBuffer();
//            String line = null;
//            while((line = reader.readLine()) != null){
//                stringBuffer.append(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            conn.disconnect();
//            try {
//                in.close();
//                reader.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return stringBuffer.toString();
//    }
//    /**
//     *从json字符串中得到指定的key的value值；
//     */
//    public static String getJsonValue(String str, String key){
//        JSONObject json = JSONObject.parseObject(str);
//        Object s = json.get(key);
//        if(s != null){
//            return s.toString();
//        }else{
//            return "";
//        }
//    }
//    /**
//     * 生成UUID字符串
//     *
//     * @return 32位的UUID密钥
//     */
//    public static String getUUID() throws Exception{
//        String uuid = UUID.randomUUID().toString();
//        uuid = uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
//        return uuid;
//    }
//    /**
//     * 随机生成3位数字符串
//     *
//     * @return 一个三位数的随机码字符串
//     */
//    public static String getRandom() {
//        int number;
//        while (true) {
//            number = (int) (Math.random() * 1000);
//            if (number >= 100 && number < 1000) {
//                break;
//            }
//        }
//        String string=String.valueOf(number);
//        return string;
//    }
//    /**
//     * MD5加码 生成32位md5码(不可逆的)
//     *
//     * @param inStr 加密的字符串
//     * @return 一个加密的32位密钥
//     */
//    public static String string2MD5(String inStr) throws NoSuchAlgorithmException{
//        MessageDigest md5;
//        String string="";
//        try {
//            md5 = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            return string;
//        }
//        char[] charArray = inStr.toCharArray();
//        byte[] byteArray = new byte[charArray.length];
//        for (int i = 0; i < charArray.length; i++) {
//            byteArray[i] = (byte) charArray[i];
//        }
//        byte[] md5Bytes = md5.digest(byteArray);
//        StringBuffer hexValue = new StringBuffer();
//        for (int i = 0; i < md5Bytes.length; i++) {
//            int val = ((int) md5Bytes[i]) & 0xff;
//            if (val < 16) {
//                hexValue.append("0");
//            }
//            hexValue.append(Integer.toHexString(val));
//        }
//        string=hexValue.toString();
//        return string;
//    }
//    /**
//     * 转换编码 ISO-8859-1到GB2312
//     * @param text
//     * @return
//     */
//    public static final String ISO2GB(String text) {
//        String result = "";
//        try {
//            result = new String(text.getBytes("ISO-8859-1"), "GB2312");
//        }
//        catch (UnsupportedEncodingException ex) {
//            result = ex.toString();
//        }
//        return result;
//    }
//    /**
//     * 转换编码 GB2312到ISO-8859-1
//     * @param text
//     * @return
//     */
//    public static final String GB2ISO(String text) {
//        String result = "";
//        try {
//            result = new String(text.getBytes("GB2312"), "ISO-8859-1");
//        }
//        catch (UnsupportedEncodingException ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//    /**
//     * Utf8URL编码
//     * @param s
//     * @return
//     */
//    public static final String Utf8URLencode(String text) {
//        StringBuffer result = new StringBuffer();
//
//        for (int i = 0; i < text.length(); i++) {
//
//            char c = text.charAt(i);
//            if (c >= 0 && c <= 255) {
//                result.append(c);
//            }else {
//
//                byte[] b = new byte[0];
//                try {
//                    b = Character.toString(c).getBytes("UTF-8");
//                }catch (Exception ex) {
//
//                }
//                for (int j = 0; j < b.length; j++) {
//                    int k = b[j];
//                    if (k < 0) k += 256;
//                    result.append("%" + Integer.toHexString(k).toUpperCase());
//                }
//            }
//        }
//        return result.toString();
//    }
//    /**
//     * Utf8URL解码
//     * @param text
//     * @return
//     */
//    public static final String Utf8URLdecode(String text) {
//        String result = "";
//        int p = 0;
//        if (text!=null && text.length()>0){
//            text = text.toLowerCase();
//            p = text.indexOf("%e");
//            if (p == -1) return text;
//            while (p != -1) {
//                result += text.substring(0, p);
//                text = text.substring(p, text.length());
//                if (text == "" || text.length() < 9) return result;
//                result += CodeToWord(text.substring(0, 9));
//                text = text.substring(9, text.length());
//                p = text.indexOf("%e");
//            }
//        }
//        return result + text;
//    }
//    /**
//     * 读取配置文件
//     * @param strfile
//     * @return
//     */
//    public static Configuration getConfig(String strfile){
//        Configuration config = null;
//        try {
//            ConfigurationFactory factory = new ConfigurationFactory(strfile);
////			URL configURL = new File(strfile).toURL();
////			factory.setConfigurationFileName(configURL.toString());
//            config = factory.getConfiguration();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return config;
//    }
//    /**
//     * 在将数据存入数据库前转换
//     * @param strVal 要转换的字符串
//     * @return 从“ISO8859_1”到“GBK”得到的字符串
//     * @since  1.0
//     */
//    public static String toChinese(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = strVal.trim();
//                strVal = new String(strVal.getBytes("ISO8859_1"), "GBK");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    /**
//     * 编码转换 从UTF-8到GBK
//     * @param strVal
//     * @return
//     */
//    public static String toGBK(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = strVal.trim();
//                strVal = new String(strVal.getBytes("UTF-8"), "GBK");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    /**
//     * 将数据从数据库中取出后转换   *
//     * @param strVal 要转换的字符串
//     * @return 从“GBK”到“ISO8859_1”得到的字符串
//     * @since  1.0
//     */
//    public static String toISO(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = new String(strVal.getBytes("GBK"), "ISO8859_1");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    public static String gbk2UTF8(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = new String(strVal.getBytes("GBK"), "UTF-8");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    public static String ISO2UTF8(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = new String(strVal.getBytes("ISO-8859-1"), "UTF-8");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    public static String UTF82ISO(String strVal) {
//        try {
//            if (strVal == null) {
//                return "";
//            } else {
//                strVal = new String(strVal.getBytes("UTF-8"), "ISO-8859-1");
//                return strVal;
//            }
//        } catch (Exception exp) {
//            return "";
//        }
//    }
//    public static String getUuidByJdk(boolean is32bit)
//    {
//        String uuid = UUID.randomUUID().toString();
//        if (is32bit) {
//            return uuid.toString().replace("-", "");
//        }
//        return uuid;
//    }
//
//    /**
//     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
//     * @param sourceFilePath :待压缩的文件路径
//     * @param zipFilePath :压缩后存放路径
//     * @param fileName :压缩后文件的名称
//     * @return
//     */
//    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){
//        boolean flag = false;
//        File sourceFile = new File(sourceFilePath);
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        FileOutputStream fos = null;
//        ZipOutputStream zos = null;
//
//        if(sourceFile.exists() == false){
//            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
//        }else{
//            try {
//                File zipFile = new File(zipFilePath + "/" + fileName +".zip");
//                if(zipFile.exists()){
//                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
//                }else{
//                    File[] sourceFiles = sourceFile.listFiles();
//                    if(null == sourceFiles || sourceFiles.length<1){
//                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
//                    }else{
//                        fos = new FileOutputStream(zipFile);
//                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
//                        byte[] bufs = new byte[1024*10];
//                        for(int i=0;i<sourceFiles.length;i++){
//                            //创建ZIP实体，并添加进压缩包
//                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
//                            zos.putNextEntry(zipEntry);
//                            //读取待压缩的文件并写进压缩包里
//                            fis = new FileInputStream(sourceFiles[i]);
//                            bis = new BufferedInputStream(fis, 1024*10);
//                            int read = 0;
//                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
//                                zos.write(bufs,0,read);
//                            }
//                        }
//                        flag = true;
//                    }
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            } finally{
//                //关闭流
//                try {
//                    if(null != bis) bis.close();
//                    if(null != zos) zos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return flag;
//    }
//    /**
//     * 生成Token
//     * Token：Nv6RRuGEVvmGjB+jimI/gw==
//     * @return
//     */
//    public String makeToken(){  //checkException
//        //  7346734837483  834u938493493849384  43434384
//        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
//        //数据指纹   128位长   16个字节  md5
//        try {
//            MessageDigest md = MessageDigest.getInstance("md5");
//            byte md5[] =  md.digest(token.getBytes());
//            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
//            BASE64Encoder encoder = new BASE64Encoder();
//            return encoder.encode(md5);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
