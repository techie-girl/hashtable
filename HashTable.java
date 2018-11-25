/*
/*
Created by Arazoo Hoseyni on 11/24/2018
 */
 */

package hashtable;

/**
 * Data item 
 */
class DataItem {
	private int key;

	/**
	 * Constructor
	 * @param  data [description]
	 * @return      [description]
	 */
	public DataItem(int data) {
		this.key = data;
	}

	/**
	 * Get key
	 * @return [description]
	 */
	public int getKey() {
		return this.key;
	}
}

/**
 * Hashtable implementation
 */
public class HashTable {
	private DataItem[] dataArray;
	private int arraySize;
	private static DataItem noItem;

	static {
		noItem = new DataItem(-1);
	}

    /**
     * initializtion
     * @param int size
     * @return
     */
	public HashTable(int size) {
		if (size > 0) {
			arraySize = size;
			dataArray = new DataItem[arraySize];
		}
	}

	
    /**
     * insert an item, using linear probing to handles collision
     * @param int key
     * @return
     */
	public void insertDataItem(int key) {
		DataItem data = new DataItem(key);
		int hashCode = getHashCode(key);
		while (dataArray[hashCode] != null && dataArray[hashCode] != noItem) {
			++hashCode; //linear probing
			hashCode %= arraySize;
		}
		dataArray[hashCode] = data;

	}
	
	
    /**
     * delete item by key, using linear probing to handles collision
     * @param int key
     * @return
     */
	public void deleteDataItem(int key) {
		int hashCode = getHashCode(key);
		while (dataArray[hashCode] != null) {// /
			if (dataArray[hashCode].getKey() == key) {
				dataArray[hashCode] = noItem;
				System.out.println("delete success");
				return;
			} else {
				hashCode++;
				hashCode %= arraySize;// /
			}
		}
		System.out.println("not found it:" + key);
	}

    /**
     * find item by key
     * @param int key
     * @return DataItem
     */
	public DataItem findDataItem(int key) {
		int hashCode = getHashCode(key);
		while (dataArray[hashCode] != null) {// //
			if (dataArray[hashCode].getKey() == key) {
				return dataArray[hashCode];
			} else {
				hashCode++;
				hashCode %= arraySize;
			}
		}
		return null;
	}

    /**
     * output items in the hash table 
     * @param
     * @return
     */
	public void displayDataItem() {
		for (int i = 0; i < this.arraySize; i++) {
			if (dataArray[i] != null) {
				System.out.print(" " + i + "," + dataArray[i].getKey() + " ");
			}
		}
	}

	
    /**
     * hash function to get hash code
     * @param int key
     * @return int
     */
	public int getHashCode(int key) {
		if (key < 0) {
			return -(key % 13);
		}
		return key % 13;
	}
	
	
    /**
     * main method for test
     * @param
     * @return
     */
	public static void main(String args[]) {
		HashTable hashT = new HashTable(15);
		hashT.insertDataItem(1);
		hashT.insertDataItem(5);
		hashT.insertDataItem(21);
		hashT.insertDataItem(26);
		hashT.insertDataItem(39);
		hashT.insertDataItem(14);
		hashT.insertDataItem(15);
		hashT.insertDataItem(16);
		hashT.insertDataItem(17);
		hashT.insertDataItem(18);
		hashT.insertDataItem(19);
		hashT.insertDataItem(20);
		hashT.insertDataItem(111);
		hashT.insertDataItem(145);
		hashT.insertDataItem(146);
		
		hashT.displayDataItem();
	}

}