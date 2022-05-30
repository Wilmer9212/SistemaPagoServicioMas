package com.sistema.util;

public class configTaecel {

    private String url = "https://taecel.com/";
    private String basePath = "app/api/";
    private String key = "b9db0c5be6a058cafb675f26a1cbbdd0";
    private String nip = "80e54e50a593872c4170739309b65097";

    private String endpoint_getProducts = "getProducts";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEndpoint_getProducts() {
        return endpoint_getProducts;
    }

    public void setEndpoint_getProducts(String endpoint_getProducts) {
        this.endpoint_getProducts = endpoint_getProducts;
    }

    @Override
    public String toString() {
        return "configTaecel{" + "url=" + url + ", basePath=" + basePath + ", key=" + key + ", nip=" + nip + ", endpoint_getProducts=" + endpoint_getProducts + '}';
    }
    
    

}
