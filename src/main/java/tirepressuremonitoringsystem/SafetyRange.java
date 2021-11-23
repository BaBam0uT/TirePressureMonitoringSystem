package tirepressuremonitoringsystem;

public class SafetyRange {
	final double lowThreshold;
	final double highThreshold;
	
	public SafetyRange(double lowThreshold, double highThreshold) {
		super();
		this.lowThreshold = lowThreshold;
		this.highThreshold = highThreshold;
	}
	
	public boolean doesNotContain(double value) {
		return value < this.lowThreshold || this.highThreshold < value;
	}
}
