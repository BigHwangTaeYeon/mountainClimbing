package side.project.publicapi.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CultureApiVO {
    private int p_seq;
    private String title;
    private String period;
    private String event_period;
    private String event_site;
    private String charge;
    private String contact_point;
    private String url;
    private String image_object;
    private String description;
    private String view_count;
    private String reg_date;

    private String num_of_rows;
    private String page_no;
    private String total_count;

    //Efective java Builder
    public static class Builder{
        private int p_seq;

        private String title = "";
        private String period = "";
        private String event_period = "";
        private String event_site = "";
        private String charge = "";
        private String contact_point = "";
        private String url = "";
        private String image_object = "";
        private String description = "";
        private String view_count = "";
        private String reg_date = "";

        public Builder(int p_seq){
            this.p_seq = p_seq;
        }
        public Builder title(String val)
            {title = val; return this;}
        public Builder period(String val)
            {period = val; return this;}
        public Builder event_period(String val)
            {event_period = val; return this;}
        public Builder event_site(String val)
            {event_site = val; return this;}
        public Builder charge(String val)
            {charge = val; return this;}
        public Builder contact_point(String val)
            {contact_point = val; return this;}
        public Builder url(String val)
            {url = val; return this;}
        public Builder image_object(String val)
            {image_object = val; return this;}
        public Builder description(String val)
            {description = val; return this;}
        public Builder view_count(String val)
            {view_count = val; return this;}
        public Builder reg_date(String val)
            {reg_date = val; return this;}
        
        public CultureApiVO build() {
            return new CultureApiVO(this);
        }
    }
    private CultureApiVO (Builder builder){
        p_seq = builder.p_seq;
        title = builder.title;
        period = builder.period;
        event_period = builder.event_period;
        event_site = builder.event_site;
        charge = builder.charge;
        contact_point = builder.contact_point;
        url = builder.url;
        image_object = builder.image_object;
        description = builder.description;
        view_count = builder.view_count;
        reg_date = builder.reg_date;
    }
    public CultureApiVO() {
    }
}
