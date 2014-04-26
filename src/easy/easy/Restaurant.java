package easy.easy;

public class Restaurant extends Attraction implements Rated{

	private int rating;
	
	public Restaurant(String n, int a, int s, int r)
	{
		super(n, a, s);
		rating = r;
	}

	@Override
	public boolean highlyRated()
	{
		return rating >= 4;
	}
	
}