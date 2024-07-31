import java.util.*;

class Post {
    int postId;
    int userId;
    long timestamp;
    
    public Post(int postId, int userId, long timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }
}

class Facebook {
    Map<Integer, Set<Integer>> followers; // Map to store followers of each user
    Map<Integer, List<Post>> userPosts; // Map to store posts of each user
    
    public Facebook() {
        followers = new HashMap<>();
        userPosts = new HashMap<>();
    }
    
    // Method to create a new post
    public void createPost(int userId, int postId) {
        long timestamp = System.currentTimeMillis();
        Post post = new Post(postId, userId, timestamp);
        
        // Add the post to the user's list of posts
        if (!userPosts.containsKey(userId)) {
            userPosts.put(userId, new ArrayList<>());
        }
        userPosts.get(userId).add(post);
    }
    
    // Method to get the 10 most recent post ids in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        PriorityQueue<Post> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.timestamp, a.timestamp));
        
        // Add user's own posts to the heap
        if (userPosts.containsKey(userId)) {
            for (Post post : userPosts.get(userId)) {
                maxHeap.add(post);
            }
        }
        
        // Add followees' posts to the heap
        for (int followeeId : followees) {
            if (userPosts.containsKey(followeeId)) {
                for (Post post : userPosts.get(followeeId)) {
                    maxHeap.add(post);
                }
            }
        }
        
        // Retrieve 10 most recent posts
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            newsFeed.add(maxHeap.poll().postId);
            count++;
        }
        
        return newsFeed;
    }
    
    // Method to follow a user
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    // Method to unfollow a user
    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
    
    // Method to delete a post
    public void deletePost(int userId, int postId) {
        if (userPosts.containsKey(userId)) {
            userPosts.get(userId).removeIf(post -> post.postId == postId);
        }
    }
    
    // Method to get the most recent post ids in the user's news feed in a paginated manner
    public List<Integer> getNewsFeedPaginated(int userId, int pageNumber) {
        List<Integer> newsFeed = getNewsFeed(userId);
        List<Integer> result = new ArrayList<>();
        int pageSize = 2;
        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, newsFeed.size());
        
        for (int i = start; i < end; i++) {
            result.add(newsFeed.get(i));
        }
        
        return result;
    }
}
