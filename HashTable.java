package HashTablePackage;

import java.util.Scanner;

class HashTable<K, V> {
	
	int entries=0;
	int sizeofhash;
	int curr_ind;
	EntryToHash<K,V> hashTable[];
	@SuppressWarnings("unchecked")
	HashTable()
	{
		sizeofhash = 10;
		hashTable = new EntryToHash[10];
		for(int i=0;i<10;i++)
		{
			hashTable[i] = new EntryToHash<K, V>();
		}
	}
	@SuppressWarnings("unchecked")
	HashTable(int size)
	{
		sizeofhash = size;
		hashTable = new EntryToHash[size];
		for(int i=0;i<size;i++)
		{
			hashTable[i] = new EntryToHash<K, V>();
		}
	}
	public class EntryToHash<K, V> implements Entry<K, V>{
		
		Integer K;
		String V;
		Object next;

		@SuppressWarnings("unchecked")
		@Override
		public String get(Integer K) {
			return hashTable[h(K)].V;
		}
		@SuppressWarnings("unchecked")
		@Override
		public String Put(Integer K, Object V) {
			
			float formFactor = (float) entries/sizeofhash;
			if(formFactor>0.9)
			{
				System.out.println("Hash Table is full.");
				return null;
			}
			
			entries++;
			if(hashTable[curr_ind].V == null)
			{
				hashTable[curr_ind].K = K;
				hashTable[curr_ind].V = (String) V;
				hashTable[curr_ind].next = null;
				return null;
			}
			else
			{
				String value = hashTable[curr_ind].V;
				hashTable[curr_ind].K = K;
				hashTable[curr_ind].V = (String) V;
				hashTable[curr_ind].next = null;
				
				
				return value+" is removed now. ";
			}
			
			
		}
		@Override
		public String Remove(Integer K) {
			String value = hashTable[h(K)].V;
			hashTable[h(K)].V = null;
			return value;
		}
		
	}
	
	public int size() {
		return entries;
	}

	public boolean isEmpty() {
		if(entries==0)
			return true;
		else 
			return false;
	}
	
	int h(Integer K)
	{
 		curr_ind = K%sizeofhash;
		return K%sizeofhash;
	}
	
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to define hash table size: Y|N");
		String ch = input.next();
		if(ch.equals("Y") || ch.equals("y"))
		{
			System.out.println("Enter size: ");
			int size = input.nextInt();
			HashTable obj = new HashTable(size);
			System.out.println(obj.isEmpty());
			System.out.println(obj.hashTable[obj.h(2)].Put(2, "Hassan"));
			System.out.println(obj.hashTable[obj.h(2)].Put(2, "Zeshan"));
			System.out.println(obj.hashTable[obj.h(3)].Put(3, "Zohran"));
			System.out.println(obj.hashTable[obj.h(4)].Put(4, "Rizwan"));
			System.out.println(obj.hashTable[obj.h(4)].Put(4, "Farhan"));
			System.out.println(obj.hashTable[obj.h(5)].Put(5, "Hamdan"));
			System.out.println("Remove method called for, "+obj.hashTable[obj.h(3)].Remove(3));
			System.out.println(""+obj.size());
			
			System.out.println("Getting Value");
			
			System.out.println(obj.hashTable[obj.h(4)].get(4));
		}
		else
		{
			HashTable obj = new HashTable();
			System.out.println(obj.isEmpty());
			System.out.println(obj.hashTable[obj.h(2)].Put(2, "Hassan"));
			System.out.println(obj.hashTable[obj.h(2)].Put(2, "Zeshan"));
			System.out.println(obj.hashTable[obj.h(3)].Put(3, "Zohran"));
			System.out.println(obj.hashTable[obj.h(4)].Put(4, "Rizwan"));
			System.out.println(obj.hashTable[obj.h(4)].Put(4, "Farhan"));
			System.out.println(obj.hashTable[obj.h(5)].Put(5, "Hamdan"));
			System.out.println("Remove method called for, "+obj.hashTable[obj.h(3)].Remove(3));
			System.out.println(""+obj.size());
			
			System.out.println("Getting Value");
			
			System.out.println(obj.hashTable[obj.h(4)].get(4));
		}
		
		
	}

}
