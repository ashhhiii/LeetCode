class Twitter {

    private static int timestamp = 0;

    // Store tweets of users
    private Map<Integer, List<Tweet>> tweets;

    // Store following relationships
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    // User posts a new tweet
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // Get the 10 most recent tweets of the user and followed users
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        // Add user's tweets
        if (tweets.containsKey(userId)) {
            minHeap.addAll(tweets.get(userId));
        }

        // Add followees' tweets
        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    minHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        // Extract top 10 tweets
        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!minHeap.isEmpty() && count < 10) {
            newsFeed.add(minHeap.poll().tweetId);
            count++;
        }

        return newsFeed;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot follow himself
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    // Helper class for Tweet object
    private static class Tweet {
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
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