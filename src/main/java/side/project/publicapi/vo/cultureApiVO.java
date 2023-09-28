package side.project.publicapi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CultureApiVO {
    private String pSeq;
    private String title;
    private String period;
    private String eventPeriod;
    private String eventSite;
    private String charge;
    private String contactPoint;
    private String url;
    private String imageObject;
    private String description;
    private String viewCount;
    private String regDate;

    private String numOfRows;
    private String pageNo;
    private String totalCount;

    //Efective java Builder
    public static class Builder{
        private String pSeq;

        private String title = "";
        private String period = "";
        private String eventPeriod = "";
        private String eventSite = "";
        private String charge = "";
        private String contactPoint = "";
        private String url = "";
        private String imageObject = "";
        private String description = "";
        private String viewCount = "";
        private String regDate = "";

        public Builder(String pSeq){
            this.pSeq = pSeq;
        }
        public Builder title(String val)
            {title = val; return this;}
        public Builder period(String val)
            {period = val; return this;}
        public Builder eventPeriod(String val)
            {eventPeriod = val; return this;}
        public Builder eventSite(String val)
            {eventSite = val; return this;}
        public Builder charge(String val)
            {charge = val; return this;}
        public Builder contactPoint(String val)
            {contactPoint = val; return this;}
        public Builder url(String val)
            {url = val; return this;}
        public Builder imageObject(String val)
            {imageObject = val; return this;}
        public Builder description(String val)
            {description = val; return this;}
        public Builder viewCount(String val)
            {viewCount = val; return this;}
        public Builder regDate(String val)
            {regDate = val; return this;}
        
        public CultureApiVO build() {
            return new CultureApiVO(this);
        }
    }
    private CultureApiVO (Builder builder){
        pSeq = builder.pSeq;
        title = builder.title;
        period = builder.period;
        eventPeriod = builder.eventPeriod;
        eventSite = builder.eventSite;
        charge = builder.charge;
        contactPoint = builder.contactPoint;
        url = builder.url;
        imageObject = builder.imageObject;
        description = builder.description;
        viewCount = builder.viewCount;
        regDate = builder.regDate;
    }
    public CultureApiVO() {
    }
}
