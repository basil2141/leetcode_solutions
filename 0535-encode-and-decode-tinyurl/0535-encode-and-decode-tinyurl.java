public class Codec {
    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        StringBuilder sb = new StringBuilder();

        String s = "http://tinyurl.com/";
        sb.append(s);
        String check = "";
        while(true){
            char ch = (char) ((int)Math.random() * 100 + '0');
            sb.append(ch);
            check = sb.toString();
            if(!map.containsKey(check)){
                map.put(check, longUrl);
                break;
            }
        }
        return check;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));