package com.arifin.helper;

import java.util.List;
import java.util.Map;

/**
 * Created by arifin on 12/11/16.
 */
public class MappingCore {

    private List datas;
    private long total;
    private long jumlah;
    private Map<String,String> param;


    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getJumlah() {
        return jumlah;
    }

    public void setJumlah(long jumlah) {
        this.jumlah = jumlah;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
}
