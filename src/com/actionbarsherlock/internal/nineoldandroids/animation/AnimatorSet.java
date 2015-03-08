// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            Animator, ValueAnimator, ObjectAnimator

public final class AnimatorSet extends Animator
{

    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap mNodeMap;
    private ArrayList mNodes;
    private ArrayList mPlayingSet;
    private AnimatorSetListener mSetListener;
    private ArrayList mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;

    public AnimatorSet()
    {
        mPlayingSet = new ArrayList();
        mNodeMap = new HashMap();
        mNodes = new ArrayList();
        mSortedNodes = new ArrayList();
        mNeedsSort = true;
        mSetListener = null;
        mTerminated = false;
        mStarted = false;
        mStartDelay = 0L;
        mDelayAnim = null;
        mDuration = -1L;
    }

    private void sortNodes()
    {
        if (mNeedsSort)
        {
            mSortedNodes.clear();
            ArrayList arraylist = new ArrayList();
            int i1 = mNodes.size();
            for (int j1 = 0; j1 < i1; j1++)
            {
                Node node3 = (Node)mNodes.get(j1);
                if (node3.dependencies == null || node3.dependencies.size() == 0)
                {
                    arraylist.add(node3);
                }
            }

            ArrayList arraylist1 = new ArrayList();
            for (; arraylist.size() > 0; arraylist1.clear())
            {
                int k1 = arraylist.size();
                for (int l1 = 0; l1 < k1; l1++)
                {
                    Node node1 = (Node)arraylist.get(l1);
                    mSortedNodes.add(node1);
                    if (node1.nodeDependents == null)
                    {
                        continue;
                    }
                    int i2 = node1.nodeDependents.size();
                    for (int j2 = 0; j2 < i2; j2++)
                    {
                        Node node2 = (Node)node1.nodeDependents.get(j2);
                        node2.nodeDependencies.remove(node1);
                        if (node2.nodeDependencies.size() == 0)
                        {
                            arraylist1.add(node2);
                        }
                    }

                }

                arraylist.clear();
                arraylist.addAll(arraylist1);
            }

            mNeedsSort = false;
            if (mSortedNodes.size() != mNodes.size())
            {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
        } else
        {
            int i = mNodes.size();
            for (int j = 0; j < i; j++)
            {
                Node node = (Node)mNodes.get(j);
                if (node.dependencies != null && node.dependencies.size() > 0)
                {
                    int k = node.dependencies.size();
                    for (int l = 0; l < k; l++)
                    {
                        Dependency dependency = (Dependency)node.dependencies.get(l);
                        if (node.nodeDependencies == null)
                        {
                            node.nodeDependencies = new ArrayList();
                        }
                        if (!node.nodeDependencies.contains(dependency.node))
                        {
                            node.nodeDependencies.add(dependency.node);
                        }
                    }

                }
                node.done = false;
            }

        }
    }

    public final void cancel()
    {
        mTerminated = true;
        if (!isStarted())
        {
            break MISSING_BLOCK_LABEL_180;
        }
        ArrayList arraylist;
        Iterator iterator;
        Iterator iterator1;
        if (mListeners != null)
        {
            ArrayList arraylist1 = (ArrayList)mListeners.clone();
            for (Iterator iterator2 = arraylist1.iterator(); iterator2.hasNext(); ((Animator.AnimatorListener)iterator2.next()).onAnimationCancel(this)) { }
            arraylist = arraylist1;
        } else
        {
            arraylist = null;
        }
        if (mDelayAnim == null || !mDelayAnim.isRunning()) goto _L2; else goto _L1
_L1:
        mDelayAnim.cancel();
_L4:
        if (arraylist != null)
        {
            for (iterator1 = arraylist.iterator(); iterator1.hasNext(); ((Animator.AnimatorListener)iterator1.next()).onAnimationEnd(this)) { }
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (mSortedNodes.size() > 0)
        {
            iterator = mSortedNodes.iterator();
            while (iterator.hasNext()) 
            {
                ((Node)iterator.next()).animation.cancel();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        mStarted = false;
    }

    public final volatile Animator clone()
    {
        return clone();
    }

    public final AnimatorSet clone()
    {
        AnimatorSet animatorset = (AnimatorSet)super.clone();
        animatorset.mNeedsSort = true;
        animatorset.mTerminated = false;
        animatorset.mStarted = false;
        animatorset.mPlayingSet = new ArrayList();
        animatorset.mNodeMap = new HashMap();
        animatorset.mNodes = new ArrayList();
        animatorset.mSortedNodes = new ArrayList();
        HashMap hashmap = new HashMap();
        Iterator iterator = mNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Node node2 = (Node)iterator.next();
            Node node3 = node2.clone();
            hashmap.put(node2, node3);
            animatorset.mNodes.add(node3);
            animatorset.mNodeMap.put(node3.animation, node3);
            node3.dependencies = null;
            node3.tmpDependencies = null;
            node3.nodeDependents = null;
            node3.nodeDependencies = null;
            ArrayList arraylist = node3.animation.getListeners();
            if (arraylist != null)
            {
                Iterator iterator3 = arraylist.iterator();
                ArrayList arraylist1 = null;
                do
                {
                    if (!iterator3.hasNext())
                    {
                        break;
                    }
                    Animator.AnimatorListener animatorlistener = (Animator.AnimatorListener)iterator3.next();
                    if (animatorlistener instanceof AnimatorSetListener)
                    {
                        if (arraylist1 == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(animatorlistener);
                    }
                } while (true);
                if (arraylist1 != null)
                {
                    Iterator iterator4 = arraylist1.iterator();
                    while (iterator4.hasNext()) 
                    {
                        arraylist.remove((Animator.AnimatorListener)iterator4.next());
                    }
                }
            }
        } while (true);
        Iterator iterator1 = mNodes.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Node node = (Node)iterator1.next();
            Node node1 = (Node)hashmap.get(node);
            if (node.dependencies != null)
            {
                Iterator iterator2 = node.dependencies.iterator();
                while (iterator2.hasNext()) 
                {
                    Dependency dependency = (Dependency)iterator2.next();
                    node1.addDependency(new Dependency((Node)hashmap.get(dependency.node), dependency.rule));
                }
            }
        } while (true);
        return animatorset;
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final void end()
    {
        mTerminated = true;
        if (isStarted())
        {
            if (mSortedNodes.size() != mNodes.size())
            {
                sortNodes();
                Node node;
                for (Iterator iterator2 = mSortedNodes.iterator(); iterator2.hasNext(); node.animation.addListener(mSetListener))
                {
                    node = (Node)iterator2.next();
                    if (mSetListener == null)
                    {
                        mSetListener = new AnimatorSetListener(this);
                    }
                }

            }
            if (mDelayAnim != null)
            {
                mDelayAnim.cancel();
            }
            if (mSortedNodes.size() > 0)
            {
                for (Iterator iterator1 = mSortedNodes.iterator(); iterator1.hasNext(); ((Node)iterator1.next()).animation.end()) { }
            }
            if (mListeners != null)
            {
                for (Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((Animator.AnimatorListener)iterator.next()).onAnimationEnd(this)) { }
            }
            mStarted = false;
        }
    }

    public final ArrayList getChildAnimations()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext(); arraylist.add(((Node)iterator.next()).animation)) { }
        return arraylist;
    }

    public final long getDuration()
    {
        return mDuration;
    }

    public final long getStartDelay()
    {
        return mStartDelay;
    }

    public final boolean isRunning()
    {
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext();)
        {
            if (((Node)iterator.next()).animation.isRunning())
            {
                return true;
            }
        }

        return false;
    }

    public final boolean isStarted()
    {
        return mStarted;
    }

    public final Builder play(Animator animator)
    {
        if (animator != null)
        {
            mNeedsSort = true;
            return new Builder(animator);
        } else
        {
            return null;
        }
    }

    public final void playSequentially(List list)
    {
        if (list != null && list.size() > 0)
        {
            mNeedsSort = true;
            if (list.size() == 1)
            {
                play((Animator)list.get(0));
            } else
            {
                int i = 0;
                while (i < -1 + list.size()) 
                {
                    play((Animator)list.get(i)).before((Animator)list.get(i + 1));
                    i++;
                }
            }
        }
    }

    public final transient void playSequentially(Animator aanimator[])
    {
        if (aanimator != null)
        {
            mNeedsSort = true;
            int i = aanimator.length;
            int j = 0;
            if (i == 1)
            {
                play(aanimator[0]);
            } else
            {
                while (j < -1 + aanimator.length) 
                {
                    play(aanimator[j]).before(aanimator[j + 1]);
                    j++;
                }
            }
        }
    }

    public final void playTogether(Collection collection)
    {
        if (collection != null && collection.size() > 0)
        {
            mNeedsSort = true;
            Iterator iterator = collection.iterator();
            Builder builder = null;
            while (iterator.hasNext()) 
            {
                Animator animator = (Animator)iterator.next();
                if (builder == null)
                {
                    builder = play(animator);
                } else
                {
                    builder.with(animator);
                }
            }
        }
    }

    public final transient void playTogether(Animator aanimator[])
    {
        boolean flag = true;
        if (aanimator != null)
        {
            mNeedsSort = flag;
            Builder builder = play(aanimator[0]);
            for (; flag < aanimator.length; flag++)
            {
                builder.with(aanimator[flag]);
            }

        }
    }

    public final volatile Animator setDuration(long l)
    {
        return setDuration(l);
    }

    public final AnimatorSet setDuration(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setDuration(l)) { }
        mDuration = l;
        return this;
    }

    public final void setInterpolator(Interpolator interpolator)
    {
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setInterpolator(interpolator)) { }
    }

    public final void setStartDelay(long l)
    {
        mStartDelay = l;
    }

    public final void setTarget(Object obj)
    {
        Iterator iterator = mNodes.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Animator animator = ((Node)iterator.next()).animation;
            if (animator instanceof AnimatorSet)
            {
                ((AnimatorSet)animator).setTarget(obj);
            } else
            if (animator instanceof ObjectAnimator)
            {
                ((ObjectAnimator)animator).setTarget(obj);
            }
        } while (true);
    }

    public final void setupEndValues()
    {
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setupEndValues()) { }
    }

    public final void setupStartValues()
    {
        for (Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setupStartValues()) { }
    }

    public final void start()
    {
        int i = 0;
        mTerminated = false;
        mStarted = true;
        sortNodes();
        int j = mSortedNodes.size();
label0:
        for (int k = 0; k < j; k++)
        {
            Node node2 = (Node)mSortedNodes.get(k);
            ArrayList arraylist2 = node2.animation.getListeners();
            if (arraylist2 == null || arraylist2.size() <= 0)
            {
                continue;
            }
            Iterator iterator1 = (new ArrayList(arraylist2)).iterator();
            do
            {
                Animator.AnimatorListener animatorlistener;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    animatorlistener = (Animator.AnimatorListener)iterator1.next();
                } while (!(animatorlistener instanceof DependencyListener) && !(animatorlistener instanceof AnimatorSetListener));
                node2.animation.removeListener(animatorlistener);
            } while (true);
        }

        final ArrayList nodesToStart = new ArrayList();
        int l = 0;
        while (l < j) 
        {
            Node node1 = (Node)mSortedNodes.get(l);
            if (mSetListener == null)
            {
                mSetListener = new AnimatorSetListener(this);
            }
            if (node1.dependencies == null || node1.dependencies.size() == 0)
            {
                nodesToStart.add(node1);
            } else
            {
                int l1 = node1.dependencies.size();
                for (int i2 = 0; i2 < l1; i2++)
                {
                    Dependency dependency = (Dependency)node1.dependencies.get(i2);
                    dependency.node.animation.addListener(new DependencyListener(node1, dependency.rule));
                }

                node1.tmpDependencies = (ArrayList)node1.dependencies.clone();
            }
            node1.animation.addListener(mSetListener);
            l++;
        }
        if (mStartDelay <= 0L)
        {
            Node node;
            for (Iterator iterator = nodesToStart.iterator(); iterator.hasNext(); mPlayingSet.add(node.animation))
            {
                node = (Node)iterator.next();
                node.animation.start();
            }

        } else
        {
            mDelayAnim = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new _cls1());
            mDelayAnim.start();
        }
        if (mListeners != null)
        {
            ArrayList arraylist1 = (ArrayList)mListeners.clone();
            int j1 = arraylist1.size();
            for (int k1 = 0; k1 < j1; k1++)
            {
                ((Animator.AnimatorListener)arraylist1.get(k1)).onAnimationStart(this);
            }

        }
        if (mNodes.size() == 0 && mStartDelay == 0L)
        {
            mStarted = false;
            if (mListeners != null)
            {
                ArrayList arraylist = (ArrayList)mListeners.clone();
                for (int i1 = arraylist.size(); i < i1; i++)
                {
                    ((Animator.AnimatorListener)arraylist.get(i)).onAnimationEnd(this);
                }

            }
        }
    }





/*
    static boolean access$302(AnimatorSet animatorset, boolean flag)
    {
        animatorset.mStarted = flag;
        return flag;
    }

*/


    private class Node
        implements Cloneable
    {

        public Animator animation;
        public ArrayList dependencies;
        public boolean done;
        public ArrayList nodeDependencies;
        public ArrayList nodeDependents;
        public ArrayList tmpDependencies;

        public void addDependency(Dependency dependency)
        {
            if (dependencies == null)
            {
                dependencies = new ArrayList();
                nodeDependencies = new ArrayList();
            }
            dependencies.add(dependency);
            if (!nodeDependencies.contains(dependency.node))
            {
                nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null)
            {
                node.nodeDependents = new ArrayList();
            }
            node.nodeDependents.add(this);
        }

        public Node clone()
        {
            Node node;
            try
            {
                node = (Node)super.clone();
                node.animation = animation.clone();
            }
            catch (CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError();
            }
            return node;
        }

        public volatile Object clone()
        {
            return clone();
        }

        public Node(Animator animator)
        {
            dependencies = null;
            tmpDependencies = null;
            nodeDependencies = null;
            nodeDependents = null;
            done = false;
            animation = animator;
        }
    }


    private class Dependency
    {

        static final int AFTER = 1;
        static final int WITH;
        public Node node;
        public int rule;

        public Dependency(Node node1, int i)
        {
            node = node1;
            rule = i;
        }
    }


    private class AnimatorSetListener
        implements Animator.AnimatorListener
    {

        private AnimatorSet mAnimatorSet;
        final AnimatorSet this$0;

        public void onAnimationCancel(Animator animator)
        {
            if (!mTerminated && mPlayingSet.size() == 0 && mListeners != null)
            {
                int i = mListeners.size();
                for (int j = 0; j < i; j++)
                {
                    ((Animator.AnimatorListener)mListeners.get(j)).onAnimationCancel(mAnimatorSet);
                }

            }
        }

        public void onAnimationEnd(Animator animator)
        {
            animator.removeListener(this);
            mPlayingSet.remove(animator);
            ((Node)mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (mTerminated) goto _L2; else goto _L1
_L1:
            ArrayList arraylist;
            int i;
            int j;
            arraylist = mAnimatorSet.mSortedNodes;
            i = arraylist.size();
            j = 0;
_L5:
            if (j >= i)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            if (((Node)arraylist.get(j)).done) goto _L4; else goto _L3
_L3:
            boolean flag = false;
_L6:
            if (flag)
            {
                if (mListeners != null)
                {
                    ArrayList arraylist1 = (ArrayList)mListeners.clone();
                    int k = arraylist1.size();
                    for (int l = 0; l < k; l++)
                    {
                        ((Animator.AnimatorListener)arraylist1.get(l)).onAnimationEnd(mAnimatorSet);
                    }

                }
                mAnimatorSet.mStarted = false;
            }
              goto _L2
_L4:
            j++;
              goto _L5
_L2:
            return;
            flag = true;
              goto _L6
        }

        public void onAnimationRepeat(Animator animator)
        {
        }

        public void onAnimationStart(Animator animator)
        {
        }

        AnimatorSetListener(AnimatorSet animatorset1)
        {
            this$0 = AnimatorSet.this;
            super();
            mAnimatorSet = animatorset1;
        }
    }


    private class Builder
    {

        private Node mCurrentNode;
        final AnimatorSet this$0;

        public Builder after(long l)
        {
            ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
                0.0F, 1.0F
            });
            valueanimator.setDuration(l);
            after(((Animator) (valueanimator)));
            return this;
        }

        public Builder after(Animator animator)
        {
            Node node = (Node)mNodeMap.get(animator);
            if (node == null)
            {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(node, 1);
            mCurrentNode.addDependency(dependency);
            return this;
        }

        public Builder before(Animator animator)
        {
            Node node = (Node)mNodeMap.get(animator);
            if (node == null)
            {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            node.addDependency(new Dependency(mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator)
        {
            Node node = (Node)mNodeMap.get(animator);
            if (node == null)
            {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            node.addDependency(new Dependency(mCurrentNode, 0));
            return this;
        }

        Builder(Animator animator)
        {
            this$0 = AnimatorSet.this;
            super();
            mCurrentNode = (Node)mNodeMap.get(animator);
            if (mCurrentNode == null)
            {
                mCurrentNode = new Node(animator);
                mNodeMap.put(animator, mCurrentNode);
                mNodes.add(mCurrentNode);
            }
        }
    }


    private class DependencyListener
        implements Animator.AnimatorListener
    {

        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        private void startIfReady(Animator animator)
        {
            if (!mAnimatorSet.mTerminated) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i;
            int j;
            i = mNode.tmpDependencies.size();
            j = 0;
_L5:
            Dependency dependency;
            if (j >= i)
            {
                break MISSING_BLOCK_LABEL_135;
            }
            dependency = (Dependency)mNode.tmpDependencies.get(j);
            if (dependency.rule != mRule || dependency.node.animation != animator) goto _L4; else goto _L3
_L3:
            animator.removeListener(this);
_L6:
            mNode.tmpDependencies.remove(dependency);
            if (mNode.tmpDependencies.size() == 0)
            {
                mNode.animation.start();
                mAnimatorSet.mPlayingSet.add(mNode.animation);
                return;
            }
              goto _L1
_L4:
            j++;
              goto _L5
            dependency = null;
              goto _L6
        }

        public void onAnimationCancel(Animator animator)
        {
        }

        public void onAnimationEnd(Animator animator)
        {
            if (mRule == 1)
            {
                startIfReady(animator);
            }
        }

        public void onAnimationRepeat(Animator animator)
        {
        }

        public void onAnimationStart(Animator animator)
        {
            if (mRule == 0)
            {
                startIfReady(animator);
            }
        }

        public DependencyListener(Node node, int i)
        {
            mAnimatorSet = AnimatorSet.this;
            mNode = node;
            mRule = i;
        }
    }


    private class _cls1 extends AnimatorListenerAdapter
    {

        boolean canceled;
        final AnimatorSet this$0;
        final ArrayList val$nodesToStart;

        public void onAnimationCancel(Animator animator)
        {
            canceled = true;
        }

        public void onAnimationEnd(Animator animator)
        {
            if (!canceled)
            {
                int i = nodesToStart.size();
                for (int j = 0; j < i; j++)
                {
                    Node node = (Node)nodesToStart.get(j);
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                }

            }
        }

        _cls1()
        {
            this$0 = AnimatorSet.this;
            nodesToStart = arraylist;
            super();
            canceled = false;
        }
    }

}
