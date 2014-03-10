package com.chima.alg.lru;

import java.util.*;

public class LRUForCache {
	private final PriorityQueue<LRUPage> priorityQueue = new PriorityQueue<LRUPage>(
			3, new LRUPageComparator());

	public static void main(final String[] args) throws InterruptedException {

		System.out.println(" Pages for consideration : 2, 1, 0, 2, 8, 2, 4");
		System.out.println("----------------------------------------------\n");

		final LRUForCache cache = new LRUForCache();
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("1"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("0"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("8"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("2"));
		Thread.sleep(100);
		cache.addPageToQueue(new LRUPage("4"));
		Thread.sleep(100);

		System.out.println("\nLRUCache Pages");
		System.out.println("-------------");
		cache.displayPriorityQueue();
	}

	public synchronized void addPageToQueue(final LRUPage page) {
		boolean pageExists = false;
		if (priorityQueue.size() == 3) {
			final Iterator<LRUPage> iterator = priorityQueue.iterator();

			while (iterator.hasNext()) {
				final LRUPage next = iterator.next();
				if (next.getPageName().equals(page.getPageName())) {
					/*
					 * wanted to just change the time, so that no need to poll
					 * and add again. but elements ordering does not happen, it
					 * happens only at the time of adding to the queue
					 * 
					 * In case somebody finds it, plz let me know.
					 */
					// next.setPageCreationTime(page.getPageCreationTime());

					priorityQueue.remove(next);
					System.out
							.println("Page: "
									+ page.getPageName()
									+ " already exisit in cache. Last accessed time updated");
					pageExists = true;
					break;
				}
			}
			if (!pageExists) {
				// enable it for printing the queue elemnts
				// System.out.println(priorityQueue);
				final LRUPage poll = priorityQueue.poll();
				System.out.println("Page Fault, PAGE: " + poll.getPageName()
						+ ", Replaced with PAGE: " + page.getPageName());

			}
		}
		if (!pageExists) {
			System.out.println("Page added into cache is : "
					+ page.getPageName());
		}
		priorityQueue.add(page);

	}

	public void displayPriorityQueue() {
		final Iterator<LRUPage> iterator = priorityQueue.iterator();
		while (iterator.hasNext()) {
			final LRUPage next = iterator.next();
			System.out.println(next);
		}
	}
}

class LRUPage {
	private final String pageName;
	private long pageCreationTime;

	public LRUPage(final String pagename) {
		this.pageName = pagename;
		this.pageCreationTime = System.currentTimeMillis();
	}

	public String getPageName() {
		return pageName;
	}

	public long getPageCreationTime() {
		return pageCreationTime;
	}

	public void setPageCreationTime(final long pageCreationTime) {
		this.pageCreationTime = pageCreationTime;
	}

	@Override
	public boolean equals(final Object obj) {
		final LRUPage page = (LRUPage) obj;
		if (pageCreationTime == page.pageCreationTime) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (int) (31 * pageCreationTime);
	}

	@Override
	public String toString() {
		return "PageName: " + pageName + ", PageCreationTime: "
				+ pageCreationTime;
	}
}

class LRUPageComparator implements Comparator<LRUPage> {

	public int compare(final LRUPage o1, final LRUPage o2) {
		if (o1.getPageCreationTime() > o2.getPageCreationTime()) {
			return 1;
		}
		if (o1.getPageCreationTime() < o2.getPageCreationTime()) {
			return -1;
		}
		return 0;
	}
}