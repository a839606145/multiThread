package test.multiTherad.collect;

import java.util.HashMap;

/**
 * Java util 包中的集合
 * 注意：一般接口下都会有一个Abstract相关的类
 * Iterator:迭代接口
 *    Collection：接口
 *       List 接口：可重复的
 *          ArrayList 非线程安全的 ====
 *          vector 线程安全的 内部使用Object[]  不支持Iterator并发的删除
 *             Stack 实现后进先出
 *       Queue接口
 *          PriorityQueue  非线程安全 基于优先级的无界优先级队列
 *          Deque 子接口，双端队列
 *              ArrayDeque  LinkedList 非线程安全
 *       Set接口：不可重复， 防止重复的方法是需要重写hashCode() equals() 方法
 *          HashSet 非线程安全的 无序的  内部使用HashMap<E,Object>
 *          LinkedHashSet 有序的 非线程安全的 内部使用LinkeHashMap
 *          TreeSet 继承了Set 实现了SortedSet和NavigableSet接口  
 *  不在集合类下的Map：内含有Iterator
 *              内部有自己的EntrySet ==== KeyIterator ===ValueIterator
 *          HashMap  非线程安全
 *          HashTable 线程安全 但是iterator 删除 不安全
 *          LinkedHashMap 非线程安全
 *  总结线程安全的集合： Vector>stack hashtable
 *  
 *  java.current 包下的集合
 *  	非阻塞等待队列：
 *  	 ConCurrentHashMap 线程安全 无序
 *  	 ConCurrentSkipListMap 支持排序 不允许重复
 *  	 ConCurrentSkipListSet
 *       ConCurrentLinkedQueue :队列 poll【返回并移除表头】 peek【返回不移除表头】
 *       ConCurrentLinkedDeque
 *       CopyOnWriteArrayList
 *       CopyOnWriteArraySet
 *      阻塞队列：
 *       ArrayBlockingQueue===一般在executor中使用
 *       PriorityBlockingQueue
 *       LinkedBlockingQueue=====无限的
 *       LinkedBlockingDeque
 *       SynchronousQueue===一个移除 它才能插入
 *       LinkedTransferQueue===尝试性添加数据
 * @author Administrator
 * 
 */
public class TestMain {
	
	public static void main(String args[]){
	}

}
