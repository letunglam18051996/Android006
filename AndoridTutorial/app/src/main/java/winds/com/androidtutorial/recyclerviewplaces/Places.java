package winds.com.androidtutorial.recyclerviewplaces;

public class Places {
    String address, placeName;
    String categoryID;
    String urlLogoPlace;
    int isPromotion,isMoreDetail;

    public Places(String address, String placeName, String categoryID, String urlLogoPlace, int isPromotion, int isMoreDetail) {
        this.address = address;
        this.placeName = placeName;
        this.categoryID = categoryID;
        this.urlLogoPlace = urlLogoPlace;
        this.isPromotion = isPromotion;
        this.isMoreDetail = isMoreDetail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getUrlLogoPlace() {
        return urlLogoPlace;
    }

    public void setUrlLogoPlace(String urlLogoPlace) {
        this.urlLogoPlace = urlLogoPlace;
    }

    public int getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }

    public int getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(int isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }
}


