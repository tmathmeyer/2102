package easy.easy;

public class LocatedAbove implements Select<Attraction>
{

	private final int minStreet;
	
	public LocatedAbove(int ms)
	{
		minStreet = ms;
	}
	
	@Override
	public boolean choose(Attraction t) {
		return t.getLocation().getStreet() > minStreet;
	}

}
