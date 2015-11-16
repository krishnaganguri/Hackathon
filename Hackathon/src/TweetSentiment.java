import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TweetSentiment {
	
	public Map<String, Integer> getSentiment() {
		String topic = "paris";
        ArrayList<String> tweets = TweetBank.getTweets(topic);
        ArrayList<String> tweetContent = new ArrayList<String>();
        ArrayList<Integer> tweetSentiment = new ArrayList<Integer>();
        Map<String, Integer> tweetMap = new HashMap<String, Integer>();
        int sentiment;
        NLPUsage.init();
        for(String tweet : tweets) {
        	sentiment = NLPUsage.findSentiment(tweet);
            System.out.println(tweet + " : " + sentiment);
            tweetContent.add(tweet);
            tweetSentiment.add(sentiment);
            System.out.println("tweet size : "+tweetContent.size());
            
            if(tweetContent.size()==50){
            	break;
            }
        }
        
        tweetMap.put("negitive", 0);
        tweetMap.put("positive", 0);
        tweetMap.put("neutral", 0);
        for(int i : tweetSentiment ) {
        	if(i==1){
        		int j = tweetMap.get("negitive");
        		tweetMap.put("negitive", j+1);
        	} else if(i==2){
        		int j = tweetMap.get("positive");
        		tweetMap.put("positive", j+1);
        	}
        	else{
        		int j = tweetMap.get("neutral");
        		tweetMap.put("neutral", j+1);
        	}
        }
        
        System.out.println("sentiment : "+tweetMap);
        
        return tweetMap;
		
	}
}