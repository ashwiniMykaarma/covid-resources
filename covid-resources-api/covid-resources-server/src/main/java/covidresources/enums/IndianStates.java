package covidresources.enums;

public class IndianStates {
	
	 private static final String[] states= {"Andhra Pradesh",
     "Arunachal Pradesh",
     "Assam",
     "Bihar",
     "Chhattisgarh",
     "Goa",
     "Gujarat",
     "Haryana",
     "Himachal Pradesh",
     "Jammu and Kashmir",
     "Jharkhand",
     "Karnataka",
     "Kerala",
     "Madhya Pradesh",
     "Maharashtra",
     "Manipur",
     "Meghalaya",
     "Mizoram",
     "Nagaland",
     "Odisha",
     "Punjab",
     "Rajasthan",
     "Sikkim",
     "Tamil Nadu",
     "Telangana",
     "Tripura",
     "Uttarakhand",
     "Uttar Pradesh",
     "West Bengal",
     "Andaman and Nicobar Islands",
     "Chandigarh",
     "Dadra and Nagar Haveli",
     "Daman and Diu",
     "Delhi",
     "Lakshadweep",
     "Puducherry"};
	 
	 public static Boolean isValidState(String state) {
		 for(int i=0;i<states.length;i++) {
			 if(states[i].equalsIgnoreCase(state)) {
				 return true;
			 }
		 }
		 return false;
	 }

}
