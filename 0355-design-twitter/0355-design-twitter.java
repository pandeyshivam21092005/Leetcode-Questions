class Twitter {

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;

    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId, time++);

        tweet.next = tweetMap.get(userId);

        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add user's own tweets
        if (tweetMap.containsKey(userId)) {
            pq.add(tweetMap.get(userId));
        }

        // Add tweets from followed users
        Set<Integer> followees = followMap.getOrDefault(
            userId, new HashSet<>()
        );

        for (int followee : followees) {
            if (tweetMap.containsKey(followee)) {
                pq.add(tweetMap.get(followee));
            }
        }

        // Get 10 most recent tweets
        while (!pq.isEmpty() && result.size() < 10) {

            Tweet tweet = pq.poll();

            result.add(tweet.tweetId);

            if (tweet.next != null) {
                pq.add(tweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) return;

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
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