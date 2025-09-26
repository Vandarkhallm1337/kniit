package org.kniit.lab1;

class SimpleUrl{
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtension;
    private String intParam;
    private String doubleParam;
    private String textParam;

    // Геттеры и сеттеры

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebPageExtension() {
        return webPageExtension;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }

    public String getIntParam() {
        return intParam;
    }

    public void setIntParam(String intParam) {
        this.intParam = intParam;
    }

    public String getDoubleParam() {
        return doubleParam;
    }

    public void setDoubleParam(String doubleParam) {
        this.doubleParam = doubleParam;
    }

    public String getTextParam() {
        return textParam;
    }

    public void setTextParam(String textParam) {
        this.textParam = textParam;
    }
    public String toString() {
        return "protocol = " + protocol + "\n"
             + "address = " + address + "\n"
             + "domainZone = " + domainZone + "\n"
             + "siteName = " + siteName + "\n"
             + "webpageName = " + webpageName + "\n"
             + "webPageExtention = " + webPageExtension + "\n"
             + "intParam = " + intParam + "\n"
             + "doubleParam = " + doubleParam + "\n"
             + "textParameter = " + textParam;
    }
}


public class task2{
    public static void main(String[] args) {
        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        SimpleUrl simpleUrl = new SimpleUrl();

        int protocolEnd = url.indexOf("://");
        String protocol = url.substring(0, protocolEnd);
        simpleUrl.setProtocol(protocol);

        String rest = url.substring(protocolEnd + 3);

        int pathStart = rest.indexOf("/");
        String address = rest.substring(0, pathStart);
        simpleUrl.setAddress(address);

        int dotIndex = address.lastIndexOf(".");
        String domainZone = address.substring(dotIndex + 1);
        simpleUrl.setDomainZone(domainZone);

        // поддомен
        int siteNameStart = address.indexOf(".");
        String siteName = address.substring(0, siteNameStart);
        simpleUrl.setSiteName(siteName);

        // Остальная часть после адреса
        String pathAndParams = rest.substring(pathStart + 1);

        int paramStart = pathAndParams.indexOf("?");
        String path = pathAndParams.substring(0, paramStart);
        String params = pathAndParams.substring(paramStart + 1);

        int lastSlash = path.lastIndexOf("/");
        String webpage = path.substring(lastSlash + 1); // page.jsp
        simpleUrl.setWebpageName(webpage);

        int dotPage = webpage.lastIndexOf(".");
        if (dotPage != -1) {
            String ext = webpage.substring(dotPage + 1);
            simpleUrl.setWebPageExtension(ext);
        }


        String[] paramPairs = params.split("&");
        for (String pair : paramPairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                switch (key) {
                    case "intParam":
                        simpleUrl.setIntParam(value);
                        break;
                    case "doubleParam":
                        simpleUrl.setDoubleParam(value);
                        break;
                    case "textParameter":
                        simpleUrl.setTextParam(value);
                        break;
                }
            }
        }
        System.out.println(simpleUrl.toString());
    }
}