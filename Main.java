import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

class Main {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash); 
  
        StringBuilder hexString = new StringBuilder(number.toString(16)); 

        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }

  public static void main(String[] args) {
     try 
        {
            System.out.println("SHA-256:"); 
  
            String s1 = "Voloshchuk"; 
            System.out.println("\n" + s1 + " : " + toHexString(getSHA(s1))); 

            String s2 = "01AA"; 
            System.out.println("\n" + s2 + " : " + toHexString(getSHA(s2))); 
            String result = toHexString(getSHA(s2));

            String variant = "4497472c6b2ef8e7408bd7617c0ec09607028803ded9ece1eefd10abf2ca8146";
            System.out.println("\n" + "Hash 4497472c6b2ef8e7408bd7617c0ec09607028803ded9ece1eefd10abf2ca8146 is similar" + " : " + result.equals(variant));
  
        }

        catch (NoSuchAlgorithmException e) { 
            System.out.println("Incorrect algorithm: " + e); 
        } 
    } 
  }