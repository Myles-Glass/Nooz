/**
 * Project 4, CS 2334, Section 010, May 2, 2017
 * <P>
 * This enumerated type specifies the months of a year
 * </P>
 * 
 * @author Jeffrey Glass
 * @version 1.0
 * 
 */
public enum Month {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

	/**
	 * The overridden <code>toString</code> method gives the part of day in
	 * "Title Case."
	 */
	@Override
	public String toString() {
		switch (this) {
		case JANUARY:
			return "January";
		case FEBRUARY:
			return "February";
		case MARCH:
			return "March";
		case APRIL:
			return "April";
		case MAY:
			return "May";
		case JUNE:
			return "June";
		case JULY:
			return "July";
		case AUGUST:
			return "August";
		case SEPTEMBER:
			return "September";
		case OCTOBER:
			return "October";
		case NOVEMBER:
			return "November";
		case DECEMBER:
			return "December";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public int toInt(){
		switch (this) {
		case JANUARY:
			return 1;
		case FEBRUARY:
			return 2;
		case MARCH:
			return 3;
		case APRIL:
			return 4;
		case MAY:
			return 5;
		case JUNE:
			return 6;
		case JULY:
			return 7;
		case AUGUST:
			return 8;
		case SEPTEMBER:
			return 9;
		case OCTOBER:
			return 10;
		case NOVEMBER:
			return 11;
		case DECEMBER:
			return 12;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public Month fromInt(int i){
		if(i == 1)
			return JANUARY;
		if(i == 2)
			return FEBRUARY;
		if(i == 3)
			return MARCH;
		if(i == 4)
			return APRIL;
		if(i == 5)
			return MAY;
		if(i == 6)
			return JUNE;
		if(i == 7)
			return JULY;
		if(i == 8)
			return AUGUST;
		if(i == 9)
			return SEPTEMBER;
		if(i == 10)
			return OCTOBER;
		if(i == 11)
			return NOVEMBER;
		if(i == 12)
			return DECEMBER;
		if(i < 1 && i > 12)
			throw new IllegalArgumentException();
		return null;
		}
	
}
