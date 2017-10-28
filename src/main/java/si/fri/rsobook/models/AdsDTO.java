package si.fri.rsobook.models;

public class AdsDTO {

    public String imageHandle;
    public String sponsor;
    public String message;

    public AdsDTO() {
    }

    public AdsDTO(String sponsor, String message) {
        this.sponsor = sponsor;
        this.message = message;
    }

    public AdsDTO(String imageHandle, String sponsor, String message) {
        this.imageHandle = imageHandle;
        this.sponsor = sponsor;
        this.message = message;
    }
}
