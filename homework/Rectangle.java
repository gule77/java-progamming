
public class Rectangle {
	double width;
	double height;
	
	public Rectangle() {
		width = 1;
		height = 1;
	}
	
	Rectangle(double NewWidth, double NewHeight) throws Exception {
		try {
			set(NewWidth, NewHeight);
		} catch (Exception e) {
			throw e;
		}
	}

	public void set(double NewWidth, double NewHeight) throws Exception {
		if (isValid(NewWidth, NewHeight)) {
			width = NewWidth;
			height = NewHeight;
		} else {
			String errorMessage = "Invalid input!";
			Exception e = new Exception(errorMessage);
			throw e;
		}
	}
	
	public boolean isValid(double NewWidth, double NewHeight) {
		if (NewWidth <= 0 || NewHeight <= 0) {
			return false;
		}
		
		return true;
	}
	
	double getArea() throws Exception {
		try {
			return width * height;
		} catch (Exception e) {
			throw e;
		}
	}
	
	double getPerimeter() throws Exception {
		try {
			return (width + height) * 2;
		} catch (Exception e) {
			throw e;
		}
	}
}