package easy.easy;

public abstract class Attraction implements Comparable<Attraction>
{
	private Location location;
	private String name;
	
	
	public String getName()
	{
		return name;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public Attraction(String n, int a, int s)
	{
		name = n;
		location = genLocation(a, s);
	}
	
	
	@Override
	public int compareTo(Attraction t)
	{
		return this.getName().compareTo(t.getName());
	}
	
	public Location genLocation(int a, int s)
	{
		return new Location(a, s);
	}
	
	
	class Location
	{
		private Integer ave, street;
		
		public Location(int a, int s)
		{
			setAve(a);
			setStreet(s);
		}

		public Integer getAve()
		{
			return ave;
		}
		
		public void setAve(Integer ave)
		{
			this.ave = ave;
		}

		public Integer getStreet()
		{
			return street;
		}

		public void setStreet(Integer street)
		{
			this.street = street;
		}
	}
}
