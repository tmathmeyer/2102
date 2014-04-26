package easy.easy;

public class Museum extends Attraction
{

	private int fee;
	
	public Museum(String n, int a, int s, int f) {
		super(n, a, s);
		setFee(f);
	}

	public int getFee()
	{
		return fee;
	}

	public void setFee(int fee)
	{
		this.fee = fee;
	}

}
