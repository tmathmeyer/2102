package easy.easy;

import java.util.LinkedList;

public abstract class BST<T extends Comparable<T>>
{
	public abstract BST<T> add(T t);
	public abstract boolean containsAny(Select<T> s);
	public abstract boolean allAre(Select<T> s);
	public abstract LinkedList <T> filter(Select<T> s);
	
	public BST<T> generate()
	{
		return new EBST<T>();
	}
	
	
	
	private class DBST<K extends Comparable<K>> extends BST<K>
	{
		BST<K> l, r;
		final K t;
		
		public DBST(K t2)
		{
			t = t2;
			l = new EBST<K>();
			r = new EBST<K>();
		}
		
		private DBST(K t2, BST<K> l2, BST<K> r2)
		{
			t = t2;
			l = l2;
			r = r2;
		}

		@Override
		public BST<K> add(K t)
		{
			int c = t.compareTo(t);
			if (c > 0)
			{ // go right
				return new DBST<K>(t, l.add(t), r);
			}
			if (c < 0)
			{
				return new DBST<K>(t, l, r.add(t));
			}
			return this;
		}

		@Override
		public boolean containsAny(Select<K> s)
		{
			return s.choose(t) || l.containsAny(s) || r.containsAny(s);
		}

		@Override
		public boolean allAre(Select<K> s)
		{
			return s.choose(t) && l.containsAny(s) && r.containsAny(s);
		}

		@Override
		public LinkedList<K> filter(Select<K> s)
		{
			LinkedList<K> result = l.filter(s);
			result.addAll(r.filter(s));
			if (s.choose(t))
			{
				result.add(t);
			}
			return result;
		}
	}
	
	private class EBST<K extends Comparable<K>> extends BST<K>
	{

		@Override
		public BST<K> add(K t)
		{
			return new DBST<K>(t);
		}

		@Override
		public boolean containsAny(Select<K> s)
		{
			return false;
		}

		@Override
		public boolean allAre(Select<K> s)
		{
			return true;
		}

		@Override
		public LinkedList<K> filter(Select<K> s)
		{
			return new LinkedList<K>();
		}
		
	}
}