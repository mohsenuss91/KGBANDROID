// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class LinkedHashTreeMap extends AbstractMap
    implements Serializable
{

    static final boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER = new _cls1();
    Comparator comparator;
    private EntrySet entrySet;
    final Node header;
    private KeySet keySet;
    int modCount;
    int size;
    Node table[];
    int threshold;

    public LinkedHashTreeMap()
    {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator comparator1)
    {
        size = 0;
        modCount = 0;
        if (comparator1 == null)
        {
            comparator1 = NATURAL_ORDER;
        }
        comparator = comparator1;
        header = new Node();
        table = new Node[16];
        threshold = table.length / 2 + table.length / 4;
    }

    private void doubleCapacity()
    {
        table = doubleCapacity(table);
        threshold = table.length / 2 + table.length / 4;
    }

    static Node[] doubleCapacity(Node anode[])
    {
        int i = anode.length;
        Node anode1[] = new Node[i * 2];
        AvlIterator avliterator = new AvlIterator();
        AvlBuilder avlbuilder = new AvlBuilder();
        AvlBuilder avlbuilder1 = new AvlBuilder();
        int j = 0;
        do
        {
            while (j < i) 
            {
                Node node = anode[j];
                if (node != null)
                {
                    avliterator.reset(node);
                    int k = 0;
                    int l = 0;
                    do
                    {
                        Node node1 = avliterator.next();
                        if (node1 == null)
                        {
                            break;
                        }
                        if ((i & node1.hash) == 0)
                        {
                            l++;
                        } else
                        {
                            k++;
                        }
                    } while (true);
                    Node node2;
                    if (l > 0 && k > 0)
                    {
                        avlbuilder.reset(l);
                        avlbuilder1.reset(k);
                        avliterator.reset(node);
                        do
                        {
                            Node node3 = avliterator.next();
                            if (node3 == null)
                            {
                                break;
                            }
                            if ((i & node3.hash) == 0)
                            {
                                avlbuilder.add(node3);
                            } else
                            {
                                avlbuilder1.add(node3);
                            }
                        } while (true);
                        node = avlbuilder.root();
                        node2 = avlbuilder1.root();
                    } else
                    if (l > 0)
                    {
                        node2 = null;
                    } else
                    {
                        node2 = node;
                        node = null;
                    }
                    anode1[j] = node;
                    anode1[j + i] = node2;
                }
                j++;
            }
            return anode1;
        } while (true);
    }

    private boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void rebalance(Node node, boolean flag)
    {
_L6:
        if (node == null) goto _L2; else goto _L1
_L1:
        Node node1;
        Node node2;
        int i;
        int j;
        int k;
        node1 = node.left;
        node2 = node.right;
        Node node5;
        Node node6;
        if (node1 != null)
        {
            i = node1.height;
        } else
        {
            i = 0;
        }
        if (node2 != null)
        {
            j = node2.height;
        } else
        {
            j = 0;
        }
        k = i - j;
        if (k != -2) goto _L4; else goto _L3
_L3:
        node5 = node2.left;
        node6 = node2.right;
        int k1;
        int l1;
        int i2;
        if (node6 != null)
        {
            k1 = node6.height;
        } else
        {
            k1 = 0;
        }
        if (node5 != null)
        {
            l1 = node5.height;
        } else
        {
            l1 = 0;
        }
        i2 = l1 - k1;
        if (i2 == -1 || i2 == 0 && !flag)
        {
            rotateLeft(node);
        } else
        {
            if (!$assertionsDisabled && i2 != 1)
            {
                throw new AssertionError();
            }
            rotateRight(node2);
            rotateLeft(node);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        node = node.parent;
          goto _L6
_L4:
        if (k != 2) goto _L8; else goto _L7
_L7:
        Node node3 = node1.left;
        Node node4 = node1.right;
        int l;
        int i1;
        int j1;
        if (node4 != null)
        {
            l = node4.height;
        } else
        {
            l = 0;
        }
        if (node3 != null)
        {
            i1 = node3.height;
        } else
        {
            i1 = 0;
        }
        j1 = i1 - l;
        if (j1 == 1 || j1 == 0 && !flag)
        {
            rotateRight(node);
        } else
        {
            if (!$assertionsDisabled && j1 != -1)
            {
                throw new AssertionError();
            }
            rotateLeft(node1);
            rotateRight(node);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L8:
        if (k == 0)
        {
            node.height = i + 1;
            if (flag)
            {
                return;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (!$assertionsDisabled && k != -1 && k != 1)
        {
            throw new AssertionError();
        }
        node.height = 1 + Math.max(i, j);
        if (!flag) goto _L2; else goto _L5
    }

    private void replaceInParent(Node node, Node node1)
    {
        Node node2 = node.parent;
        node.parent = null;
        if (node1 != null)
        {
            node1.parent = node2;
        }
        if (node2 != null)
        {
            if (node2.left == node)
            {
                node2.left = node1;
                return;
            }
            if (!$assertionsDisabled && node2.right != node)
            {
                throw new AssertionError();
            } else
            {
                node2.right = node1;
                return;
            }
        } else
        {
            int i = node.hash & -1 + table.length;
            table[i] = node1;
            return;
        }
    }

    private void rotateLeft(Node node)
    {
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node2.left;
        Node node4 = node2.right;
        node.right = node3;
        if (node3 != null)
        {
            node3.parent = node;
        }
        replaceInParent(node, node2);
        node2.left = node;
        node.parent = node2;
        int i;
        int j;
        int k;
        int l;
        if (node1 != null)
        {
            i = node1.height;
        } else
        {
            i = 0;
        }
        if (node3 != null)
        {
            j = node3.height;
        } else
        {
            j = 0;
        }
        node.height = 1 + Math.max(i, j);
        k = node.height;
        l = 0;
        if (node4 != null)
        {
            l = node4.height;
        }
        node2.height = 1 + Math.max(k, l);
    }

    private void rotateRight(Node node)
    {
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node1.left;
        Node node4 = node1.right;
        node.left = node4;
        if (node4 != null)
        {
            node4.parent = node;
        }
        replaceInParent(node, node1);
        node1.right = node;
        node.parent = node1;
        int i;
        int j;
        int k;
        int l;
        if (node2 != null)
        {
            i = node2.height;
        } else
        {
            i = 0;
        }
        if (node4 != null)
        {
            j = node4.height;
        } else
        {
            j = 0;
        }
        node.height = 1 + Math.max(i, j);
        k = node.height;
        l = 0;
        if (node3 != null)
        {
            l = node3.height;
        }
        node1.height = 1 + Math.max(k, l);
    }

    private static int secondaryHash(int i)
    {
        int j = i ^ (i >>> 20 ^ i >>> 12);
        return j ^ j >>> 7 ^ j >>> 4;
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    public final void clear()
    {
        Arrays.fill(table, null);
        size = 0;
        modCount = 1 + modCount;
        Node node = header;
        Node node2;
        for (Node node1 = node.next; node1 != node; node1 = node2)
        {
            node2 = node1.next;
            node1.prev = null;
            node1.next = null;
        }

        node.prev = node;
        node.next = node;
    }

    public final boolean containsKey(Object obj)
    {
        return findByObject(obj) != null;
    }

    public final Set entrySet()
    {
        EntrySet entryset = entrySet;
        if (entryset != null)
        {
            return entryset;
        } else
        {
            EntrySet entryset1 = new EntrySet();
            entrySet = entryset1;
            return entryset1;
        }
    }

    final Node find(Object obj, boolean flag)
    {
        Comparator comparator1;
        Node anode[];
        int i;
        int j;
        Node node;
        Node node1;
        int i1;
        comparator1 = comparator;
        anode = table;
        i = secondaryHash(obj.hashCode());
        j = i & -1 + anode.length;
        node = anode[j];
        if (node == null)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        Comparable comparable;
        if (comparator1 == NATURAL_ORDER)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L3:
        if (comparable != null)
        {
            i1 = comparable.compareTo(node.key);
        } else
        {
            i1 = comparator1.compare(obj, node.key);
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        node1 = node;
_L5:
        return node1;
_L2:
label0:
        {
            Node node4;
            if (i1 < 0)
            {
                node4 = node.left;
            } else
            {
                node4 = node.right;
            }
            if (node4 == null)
            {
                break label0;
            }
            node = node4;
        }
          goto _L3
        int k = i1;
_L6:
        node1 = null;
        if (!flag) goto _L5; else goto _L4
_L4:
        Node node2 = header;
        Node node3;
        int l;
        if (node == null)
        {
            if (comparator1 == NATURAL_ORDER && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            node3 = new Node(node, obj, i, node2, node2.prev);
            anode[j] = node3;
        } else
        {
            node3 = new Node(node, obj, i, node2, node2.prev);
            if (k < 0)
            {
                node.left = node3;
            } else
            {
                node.right = node3;
            }
            rebalance(node, true);
        }
        l = size;
        size = l + 1;
        if (l > threshold)
        {
            doubleCapacity();
        }
        modCount = 1 + modCount;
        return node3;
        k = 0;
          goto _L6
    }

    final Node findByEntry(java.util.Map.Entry entry)
    {
        Node node = findByObject(entry.getKey());
        boolean flag;
        if (node != null && equal(node.value, entry.getValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return node;
        } else
        {
            return null;
        }
    }

    final Node findByObject(Object obj)
    {
        Node node = null;
        if (obj != null)
        {
            Node node1;
            try
            {
                node1 = find(obj, false);
            }
            catch (ClassCastException classcastexception)
            {
                return null;
            }
            node = node1;
        }
        return node;
    }

    public final Object get(Object obj)
    {
        Node node = findByObject(obj);
        if (node != null)
        {
            return node.value;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        KeySet keyset = keySet;
        if (keyset != null)
        {
            return keyset;
        } else
        {
            KeySet keyset1 = new KeySet();
            keySet = keyset1;
            return keyset1;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            Node node = find(obj, true);
            Object obj2 = node.value;
            node.value = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        Node node = removeInternalByKey(obj);
        if (node != null)
        {
            return node.value;
        } else
        {
            return null;
        }
    }

    final void removeInternal(Node node, boolean flag)
    {
        if (flag)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node node1 = node.left;
        Node node2 = node.right;
        Node node3 = node.parent;
        if (node1 != null && node2 != null)
        {
            Node node4;
            Node node5;
            int i;
            Node node6;
            int j;
            if (node1.height > node2.height)
            {
                node4 = node1.last();
            } else
            {
                node4 = node2.first();
            }
            removeInternal(node4, false);
            node5 = node.left;
            if (node5 != null)
            {
                i = node5.height;
                node4.left = node5;
                node5.parent = node4;
                node.left = null;
            } else
            {
                i = 0;
            }
            node6 = node.right;
            j = 0;
            if (node6 != null)
            {
                j = node6.height;
                node4.right = node6;
                node6.parent = node4;
                node.right = null;
            }
            node4.height = 1 + Math.max(i, j);
            replaceInParent(node, node4);
            return;
        }
        if (node1 != null)
        {
            replaceInParent(node, node1);
            node.left = null;
        } else
        if (node2 != null)
        {
            replaceInParent(node, node2);
            node.right = null;
        } else
        {
            replaceInParent(node, null);
        }
        rebalance(node3, false);
        size = -1 + size;
        modCount = 1 + modCount;
    }

    final Node removeInternalByKey(Object obj)
    {
        Node node = findByObject(obj);
        if (node != null)
        {
            removeInternal(node, true);
        }
        return node;
    }

    public final int size()
    {
        return size;
    }

    static 
    {
        boolean flag;
        if (!com/millennialmedia/google/gson/internal/LinkedHashTreeMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    private class Node
        implements java.util.Map.Entry
    {

        final int hash;
        int height;
        final Object key;
        Node left;
        Node next;
        Node parent;
        Node prev;
        Node right;
        Object value;

        public final boolean equals(Object obj)
        {
            boolean flag;
            boolean flag1;
            flag = obj instanceof java.util.Map.Entry;
            flag1 = false;
            if (!flag) goto _L2; else goto _L1
_L1:
            java.util.Map.Entry entry = (java.util.Map.Entry)obj;
            if (key != null) goto _L4; else goto _L3
_L3:
            Object obj2;
            obj2 = entry.getKey();
            flag1 = false;
            if (obj2 != null) goto _L2; else goto _L5
_L5:
            if (value != null) goto _L7; else goto _L6
_L6:
            Object obj1;
            obj1 = entry.getValue();
            flag1 = false;
            if (obj1 != null) goto _L2; else goto _L8
_L8:
            flag1 = true;
_L2:
            return flag1;
_L4:
            boolean flag2;
            flag2 = key.equals(entry.getKey());
            flag1 = false;
            if (!flag2) goto _L2; else goto _L5
_L7:
            boolean flag3;
            flag3 = value.equals(entry.getValue());
            flag1 = false;
            if (!flag3) goto _L2; else goto _L8
        }

        public final Node first()
        {
            Node node1;
            for (Node node = left; node != null; node = node1)
            {
                node1 = node.left;
                this = node;
            }

            return this;
        }

        public final Object getKey()
        {
            return key;
        }

        public final Object getValue()
        {
            return value;
        }

        public final int hashCode()
        {
            int i;
            Object obj;
            int j;
            if (key == null)
            {
                i = 0;
            } else
            {
                i = key.hashCode();
            }
            obj = value;
            j = 0;
            if (obj != null)
            {
                j = value.hashCode();
            }
            return i ^ j;
        }

        public final Node last()
        {
            Node node1;
            for (Node node = right; node != null; node = node1)
            {
                node1 = node.right;
                this = node;
            }

            return this;
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = value;
            value = obj;
            return obj1;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(key).append("=").append(value).toString();
        }

        Node()
        {
            key = null;
            hash = -1;
            prev = this;
            next = this;
        }

        Node(Node node, Object obj, int i, Node node1, Node node2)
        {
            parent = node;
            key = obj;
            hash = i;
            height = 1;
            next = node1;
            prev = node2;
            node2.next = this;
            node1.prev = this;
        }
    }


    private class AvlIterator
    {

        private Node stackTop;

        public Node next()
        {
            Node node = stackTop;
            if (node == null)
            {
                return null;
            }
            Node node1 = node.parent;
            node.parent = null;
            Node node3;
            for (Node node2 = node.right; node2 != null; node2 = node3)
            {
                node2.parent = node1;
                node3 = node2.left;
                node1 = node2;
            }

            stackTop = node1;
            return node;
        }

        void reset(Node node)
        {
            Node node1 = null;
            Node node3;
            for (Node node2 = node; node2 != null; node2 = node3)
            {
                node2.parent = node1;
                node3 = node2.left;
                node1 = node2;
            }

            stackTop = node1;
        }

        AvlIterator()
        {
        }
    }


    private class AvlBuilder
    {

        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node stack;

        final void add(Node node)
        {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            if (leavesToSkip > 0 && (1 & size) == 0)
            {
                size = 1 + size;
                leavesToSkip = -1 + leavesToSkip;
                leavesSkipped = 1 + leavesSkipped;
            }
            node.parent = stack;
            stack = node;
            size = 1 + size;
            if (leavesToSkip > 0 && (1 & size) == 0)
            {
                size = 1 + size;
                leavesToSkip = -1 + leavesToSkip;
                leavesSkipped = 1 + leavesSkipped;
            }
            int i = 4;
            while ((size & i - 1) == i - 1) 
            {
                if (leavesSkipped == 0)
                {
                    Node node3 = stack;
                    Node node4 = node3.parent;
                    Node node5 = node4.parent;
                    node4.parent = node5.parent;
                    stack = node4;
                    node4.left = node5;
                    node4.right = node3;
                    node4.height = 1 + node3.height;
                    node5.parent = node4;
                    node3.parent = node4;
                } else
                if (leavesSkipped == 1)
                {
                    Node node1 = stack;
                    Node node2 = node1.parent;
                    stack = node2;
                    node2.right = node1;
                    node2.height = 1 + node1.height;
                    node1.parent = node2;
                    leavesSkipped = 0;
                } else
                if (leavesSkipped == 2)
                {
                    leavesSkipped = 0;
                }
                i *= 2;
            }
        }

        final void reset(int i)
        {
            leavesToSkip = (-1 + 2 * Integer.highestOneBit(i)) - i;
            size = 0;
            leavesSkipped = 0;
            stack = null;
        }

        final Node root()
        {
            Node node = stack;
            if (node.parent != null)
            {
                throw new IllegalStateException();
            } else
            {
                return node;
            }
        }

        AvlBuilder()
        {
        }
    }


    private class EntrySet extends AbstractSet
    {

        final LinkedHashTreeMap this$0;

        public void clear()
        {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return (obj instanceof java.util.Map.Entry) && findByEntry((java.util.Map.Entry)obj) != null;
        }

        public Iterator iterator()
        {
            class _cls1 extends LinkedTreeMapIterator
            {
                private class LinkedTreeMapIterator
                    implements Iterator
                {

                    int expectedModCount;
                    Node lastReturned;
                    Node next;
                    final LinkedHashTreeMap this$0;

                    public final boolean hasNext()
                    {
                        return next != header;
                    }

                    final Node nextNode()
                    {
                        Node node = next;
                        if (node == header)
                        {
                            throw new NoSuchElementException();
                        }
                        if (modCount != expectedModCount)
                        {
                            throw new ConcurrentModificationException();
                        } else
                        {
                            next = node.next;
                            lastReturned = node;
                            return node;
                        }
                    }

                    public final void remove()
                    {
                        if (lastReturned == null)
                        {
                            throw new IllegalStateException();
                        } else
                        {
                            removeInternal(lastReturned, true);
                            lastReturned = null;
                            expectedModCount = modCount;
                            return;
                        }
                    }

                    private LinkedTreeMapIterator()
                    {
                        this$0 = LinkedHashTreeMap.this;
                        super();
                        next = header.next;
                        lastReturned = null;
                        expectedModCount = modCount;
                    }

                    LinkedTreeMapIterator(_cls1 _pcls1)
                    {
                        this();
                    }
                }


                final EntrySet this$1;

                public volatile Object next()
                {
                    return next();
                }

                public java.util.Map.Entry next()
                {
                    return nextNode();
                }

                _cls1()
                {
                    this$1 = EntrySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public boolean remove(Object obj)
        {
            Node node;
            if (obj instanceof java.util.Map.Entry)
            {
                if ((node = findByEntry((java.util.Map.Entry)obj)) != null)
                {
                    removeInternal(node, true);
                    return true;
                }
            }
            return false;
        }

        public int size()
        {
            return LinkedHashTreeMap.this.size;
        }

        EntrySet()
        {
            this$0 = LinkedHashTreeMap.this;
            super();
        }
    }


    private class KeySet extends AbstractSet
    {

        final LinkedHashTreeMap this$0;

        public void clear()
        {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj)
        {
            return containsKey(obj);
        }

        public Iterator iterator()
        {
            class _cls1 extends LinkedTreeMapIterator
            {

                final KeySet this$1;

                public Object next()
                {
                    return nextNode().key;
                }

                _cls1()
                {
                    this$1 = KeySet.this;
                    super(null);
                }
            }

            return new _cls1();
        }

        public boolean remove(Object obj)
        {
            return removeInternalByKey(obj) != null;
        }

        public int size()
        {
            return LinkedHashTreeMap.this.size;
        }

        KeySet()
        {
            this$0 = LinkedHashTreeMap.this;
            super();
        }
    }


    private class _cls1
        implements Comparator
    {

        public final int compare(Comparable comparable, Comparable comparable1)
        {
            return comparable.compareTo(comparable1);
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((Comparable)obj, (Comparable)obj1);
        }

        _cls1()
        {
        }
    }

}
