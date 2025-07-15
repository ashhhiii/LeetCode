class Twitter {
    private static int timeStamp = 0;

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;

    private class Tweet {
        int tweetId;
        int timeStamp;

        Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp);

        if (tweets.containsKey(userId)) {
            minHeap.addAll(tweets.get(userId));
        }
        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    minHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!minHeap.isEmpty() && count < 10) {
            newsFeed.add(minHeap.poll().tweetId);
            count++;
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */