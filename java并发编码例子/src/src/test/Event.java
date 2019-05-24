package test;

import java.util.Date;
/**
 * 
 * @author yangfeng
 *
 */
public class Event {
	private Date date;
	private String event;
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEvent() {
		return event;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
}
