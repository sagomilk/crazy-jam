#list

#ArrayList

##init

	//构造一个初始容量为 10 的空列表
    public ArrayList() {
        this(10);
    }

##null object
//因为ArrayList中允许存在null，所以需要进行null判断

##add(int index, E element)
最根本的方法就是 System.arraycopy() 方法，该方法的根本目的就是将 index 位置空出来以供新数据插入，这里需要进行数组数据的右移，这是非常麻烦和耗时的，所以如果指定的数据集合需要进行大量插入（中间插入）操作，推荐使用 LinkedList。

##removeAll()
继承自 AbstractCollection，ArrayList 没有提供实现。

##System.arraycopy()
该方法的原型为：public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)。

##扩容

 	//计算新的容量大小，为当前容量的1.5倍
    int newCapacity = (oldCapacity * 3) / 2 + 1;

通过 google 查找，发现 1.5 倍的扩容是最好的倍数。因为一次性扩容太大(例如 2.5 倍)可能会浪费更多的内存(1.5 倍最多浪费 33%，而 2.5 被最多会浪费 60%，3.5 倍则会浪费 71%……)。但是一次性扩容太小，需要多次对数组重新分配内存，对性能消耗比较严重。所以 1.5 倍刚刚好，既能满足性能需求，也不会造成很大的内存消耗。

##
最小化 ArrayList 实例的存储量。

    public void trimToSize() {
            modCount++;
            int oldCapacity = elementData.length;
            if (size < oldCapacity) {
                elementData = Arrays.copyOf(elementData, size);
            }
        }


##命名风格参考

	//检测插入的位置是否越界
	RangeCheck(index);

	//初始容量
	initialCapacity

	// 确保容量，元素数据
	public boolean add(E e) {
        ensureCapacity(size + 1);  // Increments  modCount!!
        elementData[size++] = e;
        return true;
    }

##避免同步
在next()方法中调用了checkForComodification()方法，进行对修改的同步检查： 

    final void checkForComodification() { 
        if (modCount != expectedModCount) 
        throw new ConcurrentModificationException(); 
    } 

现在对modCount和expectedModCount的作用应该非常清楚了。在对一个集合对象进行跌代操作的同时，并不限制对集合对象的元素进行操作，这些操作包括一些可能引起跌代错误的add()或remove()等危险操作。在AbstractList中，使用了一个简单的机制来规避这些风险。这就是modCount和expectedModCount的作用所在。 

#Serializable
elementData数组对象定义为transient，需要自行实现序列化方法

    private synchronized void writeObject(java.io.ObjectOutputStream s) 
            throws java.io.IOException{ 
        // Write out element count, and any hidden stuff 
        s.defaultWriteObject(); 
       // Write out array length 
        s.writeInt(elementData.length); 
        // Write out all elements in the proper order. 
        for (int i=0; i<size; i++) 
                s.writeObject(elementData[i]); 
        } 
    }


#LikedList
##原理
基于链表实现的方式使得 LinkedList 在插入和删除时更优于 ArrayList，而随机访问则比 ArrayList 逊色些。

##属性

在 LinkedList 中提供了两个基本属性 size、header。

    private transient Entry<E> header = new Entry<E>(null, null, null);
    private transient int size = 0;

其中 size 表示的 LinkedList 的大小，header 表示链表的表头，Entry 为节点对象。

    private static class Entry<E> {
        E element;        //元素节点
        Entry<E> next;    //下一个元素
        Entry<E> previous;  //上一个元素
    }

##构造方法
LinkedList 提供了两个构造方法：LinkedList() 和 LinkedList(Collection<? extends E> c)。

    public LinkedList() {
        header.next = header.previous = header;
    }

LinkedList() 构造一个空列表。
里面没有任何元素，仅仅只是将 header 点的前一个元素、后一个元素都指向自身。