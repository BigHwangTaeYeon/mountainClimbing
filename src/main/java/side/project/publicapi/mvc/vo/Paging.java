package side.project.publicapi.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    
	private int pageNum;
	private int amount;
	
	public Paging(){
		this(1,10);
	}
	
	public Paging(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
