package easy.easy;

public class TopRated implements Select<Rated>
{
	
	@Override
	public boolean choose(Rated t)
	{
		return t.highlyRated();
	}

}
