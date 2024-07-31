import java.util.*;
public class Facebook 
{
    Map<Integer,Set<Integer>>following;
    Map<Integer, List<int[]>>userpost;
    int currenttime;

    public Facebook()
    {
        following=new HashMap<>();
        userpost=new HashMap<>();
        currenttime=0;
    }

 public void createPost(int userid,int postid)
 {
    if(!userpost.containsKey(userid)) 
	{
            userpost.put(userid,new ArrayList<>());
        }
        userpost.get(userid).add(new int[]{currenttime++,postid});
    }

 public void deletePost(int userid,int postid)
   {
     if(userpost.containsKey(userid))
       {
         List<int[]> list=userpost.get(userid);
         for(int i=0;i<list.size();i++)
	   {
                if(postid==list.get(i)[1]) 
		{
                    list.remove(i);
                    break;
                }
            }
        }
    }

 public void follow(int followerid,int followingid) 
   {
        if(!following.containsKey(followerid))
	 {
            following.put(followerid,new HashSet<>());
         }
        following.get(followerid).add(followingid);
    }

 public void unfollow(int followerId,int followeeId)
    {
        if(following.containsKey(followerId))
	 {
            following.get(followerId).remove(followeeId);
         }
    }

public List<Integer> getNewsFeed(int userid)
  {
    List<Integer> newsFeed=new ArrayList<>();
    PriorityQueue<int[]> feed=new PriorityQueue<>((a, b) -> b[0] - a[0]);

     if(userpost.containsKey(userid)) 
      {
        for(int[] post : userpost.get(userid)) 
	    {
              feed.offer(post);
            }
        }
    Set<Integer> followees = following.getOrDefault(userid, new HashSet<>());
      for(int followeeId : followees) 
	 {
            if(userpost.containsKey(followeeId)) 
	    {
                for(int[] post : userpost.get(followeeId))
	          {
                    feed.offer(post);
                }
            }
        }

        int count = 0;
        while(!feed.isEmpty() && count < 10)
	 {
            newsFeed.add(feed.poll()[1]);
            count++;
         }

        return newsFeed;
    }

public static void main(String args[])
 {
    Facebook facebook = new Facebook();
    Scanner sc = new Scanner(System.in);
    while(true)
      {
         System.out.println("1. Create Post");
         System.out.println("2. Get News Feed");
         System.out.println("3. Follow");
         System.out.println("4. Unfollow");
         System.out.println("5. Delete Post");
         System.out.print("Enter the Choice: ");
         int choice = sc.nextInt();
         switch(choice)
            {
                case 1:
                    System.out.print("Enter the UserId: ");
                    int userid=sc.nextInt();
                    System.out.print("Enter the PostId: ");
                    int postid=sc.nextInt();
                    facebook.createPost(userid, postid);
                    break;
                case 2:
                    System.out.print("Enter the UserId: ");
                    userid=sc.nextInt();
                    List<Integer> feed=facebook.getNewsFeed(userid);
                    for (Integer id : feed)
		     {
                        System.out.print(id + " ");
                     }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the Followerid: ");
                    int followerid=sc.nextInt();
                    System.out.print("Enter the FollowingId: ");
                    int followingid=sc.nextInt();
                    facebook.follow(followerid, followingid);
                    break;
                case 4:
                    System.out.print("Enter the Followerid: ");
                    followerid=sc.nextInt();
                    System.out.print("Enter the FollowingId: ");
                    followingid=sc.nextInt();
                    facebook.unfollow(followerid, followingid);
                    break;
                case 5:
                    System.out.print("Enter the UserId: ");
                    userid=sc.nextInt();
                    System.out.print("Enter the PostId: ");
                    postid=sc.nextInt();
                    facebook.deletePost(userid, postid);
                    break;
                default:
                    System.out.println("Enter the valid Choice");
                    break;
            }
        }
    }
}
