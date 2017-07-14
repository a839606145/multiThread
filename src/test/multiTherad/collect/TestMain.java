package test.multiTherad.collect;

import java.util.HashMap;

/**
 * Java util ���еļ���
 * ע�⣺һ��ӿ��¶�����һ��Abstract��ص���
 * Iterator:�����ӿ�
 *    Collection���ӿ�
 *       List �ӿڣ����ظ���
 *          ArrayList ���̰߳�ȫ�� ====
 *          vector �̰߳�ȫ�� �ڲ�ʹ��Object[]  ��֧��Iterator������ɾ��
 *             Stack ʵ�ֺ���ȳ�
 *       Queue�ӿ�
 *          PriorityQueue  ���̰߳�ȫ �������ȼ����޽����ȼ�����
 *          Deque �ӽӿڣ�˫�˶���
 *              ArrayDeque  LinkedList ���̰߳�ȫ
 *       Set�ӿڣ������ظ��� ��ֹ�ظ��ķ�������Ҫ��дhashCode() equals() ����
 *          HashSet ���̰߳�ȫ�� �����  �ڲ�ʹ��HashMap<E,Object>
 *          LinkedHashSet ����� ���̰߳�ȫ�� �ڲ�ʹ��LinkeHashMap
 *          TreeSet �̳���Set ʵ����SortedSet��NavigableSet�ӿ�  
 *  ���ڼ������µ�Map���ں���Iterator
 *              �ڲ����Լ���EntrySet ==== KeyIterator ===ValueIterator
 *          HashMap  ���̰߳�ȫ
 *          HashTable �̰߳�ȫ ����iterator ɾ�� ����ȫ
 *          LinkedHashMap ���̰߳�ȫ
 *  �ܽ��̰߳�ȫ�ļ��ϣ� Vector>stack hashtable
 *  
 *  java.current ���µļ���
 *  	�������ȴ����У�
 *  	 ConCurrentHashMap �̰߳�ȫ ����
 *  	 ConCurrentSkipListMap ֧������ �������ظ�
 *  	 ConCurrentSkipListSet
 *       ConCurrentLinkedQueue :���� poll�����ز��Ƴ���ͷ�� peek�����ز��Ƴ���ͷ��
 *       ConCurrentLinkedDeque
 *       CopyOnWriteArrayList
 *       CopyOnWriteArraySet
 *      �������У�
 *       ArrayBlockingQueue===һ����executor��ʹ��
 *       PriorityBlockingQueue
 *       LinkedBlockingQueue=====���޵�
 *       LinkedBlockingDeque
 *       SynchronousQueue===һ���Ƴ� �����ܲ���
 *       LinkedTransferQueue===�������������
 * @author Administrator
 * 
 */
public class TestMain {
	
	public static void main(String args[]){
	}

}
