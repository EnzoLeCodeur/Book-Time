
package com.example.booktime.model;

import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class Book {

    public String id;
    public VolumeInfo volumeInfo;
    public SaleInfo saleInfo;
    public AccessInfo accessInfo;

    public Boolean getEst_a_lire() {
        if(est_a_lire == null) {
            return false;
        } else {
            return  est_a_lire;
        }
    }

    public void setEst_a_lire(Boolean est_a_lire) {
        this.est_a_lire = est_a_lire;
    }

    public Boolean getEst_favoris() {
        if(est_favoris == null) {
            return false;
        } else {
            return  est_favoris;
        }
    }

    public void setEst_favoris(Boolean est_favoris) {
        this.est_favoris = est_favoris;
    }

    private Boolean est_a_lire;
    private Boolean est_favoris;

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

}
