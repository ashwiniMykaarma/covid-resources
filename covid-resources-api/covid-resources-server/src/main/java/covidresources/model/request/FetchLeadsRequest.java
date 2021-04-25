package covidresources.model.request;

import java.io.Serializable;
import java.util.List;

public class FetchLeadsRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> states;
	private List<String> cities;
	
	public FetchLeadsRequest() {
		super();
	}
	public FetchLeadsRequest(List<String> states, List<String> cities) {
		super();
		this.states = states;
		this.cities = cities;
	}
	
	public List<String> getStates() {
		return states;
	}
	public void setStates(List<String> states) {
		this.states = states;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}

}
