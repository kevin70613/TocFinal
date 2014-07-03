import java.net.*;
import java.util.*;
import java.io.*;
import org.json.*;

public class TocFinal {

    public static  JSONArray jsondata;
    public static String[] objName;
    public static ArrayList<String>[] getJSONObj;
      // Arraylist for two combination 
    public static ArrayList<String> combinTwo1 = new ArrayList<String>();
    public static ArrayList<Integer> combin2Index1 = new ArrayList<Integer>();
    public static ArrayList<String> combinTwo2 = new ArrayList<String>();
    public static ArrayList<Integer> combin2Index2 = new ArrayList<Integer>();
    public static ArrayList<Integer> countCombinTwo = new ArrayList<Integer>();
      // Arraylist for three combination 
    public static ArrayList<String> combinThree1 = new ArrayList<String>();
    public static ArrayList<Integer> combin3Index1 = new ArrayList<Integer>();
    public static ArrayList<String> combinThree2 = new ArrayList<String>();
    public static ArrayList<Integer> combin3Index2 = new ArrayList<Integer>();
    public static ArrayList<String> combinThree3 = new ArrayList<String>();
    public static ArrayList<Integer> combin3Index3 = new ArrayList<Integer>();
    public static ArrayList<Integer> countCombinThree = new ArrayList<Integer>();
      // Arraylist for four combination 
    public static ArrayList<String> combinFour1 = new ArrayList<String>();
    public static ArrayList<Integer> combin4Index1 = new ArrayList<Integer>();
    public static ArrayList<String> combinFour2 = new ArrayList<String>();
    public static ArrayList<Integer> combin4Index2 = new ArrayList<Integer>();
    public static ArrayList<String> combinFour3 = new ArrayList<String>();
    public static ArrayList<Integer> combin4Index3 = new ArrayList<Integer>();
    public static ArrayList<String> combinFour4 = new ArrayList<String>();
    public static ArrayList<Integer> combin4Index4 = new ArrayList<Integer>();    
    public static ArrayList<Integer> countCombinFour = new ArrayList<Integer>();
      // ArrayList for top k 
    public static ArrayList<String> topK1 = new ArrayList<String>();
    public static ArrayList<Integer> topKIndex1 = new ArrayList<Integer>();
    public static ArrayList<String> topK2 = new ArrayList<String>();
    public static ArrayList<Integer> topKIndex2 = new ArrayList<Integer>();
    public static ArrayList<String> topK3 = new ArrayList<String>();
    public static ArrayList<Integer> topKIndex3 = new ArrayList<Integer>();
    public static ArrayList<String> topK4 = new ArrayList<String>();
    public static ArrayList<Integer> topKIndex4 = new ArrayList<Integer>();
    public static ArrayList<Integer> topKCount = new ArrayList<Integer>();
    
	public static void main(String[] args) throws Exception{
	  String url = args[0];
      int topK = Integer.parseInt(args[1]);
      int combination = Integer.parseInt(args[2]);
  	    // handle url and get data of JSON type
      URL urlStr = new URL(url);
      BufferedReader in = new BufferedReader(new InputStreamReader(urlStr.openStream(),"utf-8"));
      jsondata = new JSONArray(new JSONTokener(in));
      
      String[] object = new String[jsondata.length()];
      String[] obj = new String[jsondata.length()];
      for(int i=0;i<jsondata.length();i++){
         object[i] = jsondata.getJSONObject(i).toString();
         obj[i] = object[i].substring(1,object[i].length()-1);
      }   
      String[] objSize = obj[0].split(",");      
      objName = new String[objSize.length];
      for(int i=0;i<objSize.length;i++){
    	  String[] objS = objSize[i].split(":");
    	  objName[i] = objS[0];
      }
      
      getJSONObj = (ArrayList<String>[]) new ArrayList[objName.length];
      
      for(int i=0;i<objName.length;i++)
    	  getJSONObj[i] = new ArrayList<String>();
      
      for(int i=0;i<jsondata.length();i++){
    	  String[] objSplit = obj[i].split(",");
    	  for(int j=0;j<objSplit.length;j++){
    	     String[] objSplitV2 = objSplit[j].split(":");
    	     for(int k=0;k<objName.length;k++){
                if(objSplitV2[0].equals(objName[k])){
            	   getJSONObj[k].add(objSplitV2[1]);  
                }   
    	     }
    	  }
      }
      in.close();
      
      switch(combination){
      case 2:{
        CombinTwo();
        for(int i=0;i<topK;i++){
  	       int max = countCombinTwo.get(0);
  	       int maxIndex = 0;
  	       for(int j=1;j<countCombinTwo.size();j++){
  		       if(countCombinTwo.get(j) > max){
  		 	     max = countCombinTwo.get(j);
  			     maxIndex = j;
  		       }
  	         }
		     topK1.add(combinTwo1.get(maxIndex));
		     topKIndex1.add(combin2Index1.get(maxIndex));
		     topK2.add(combinTwo2.get(maxIndex));
		     topKIndex2.add(combin2Index2.get(maxIndex));
		     topKCount.add(countCombinTwo.get(maxIndex));
		      // remove max element
		     combinTwo1.remove(maxIndex);
		     combin2Index1.remove(maxIndex);
		     combinTwo2.remove(maxIndex);
		     combin2Index2.remove(maxIndex);
		     countCombinTwo.remove(maxIndex);
        }
        break;
      }
      case 3:{
          CombinThree();
          for(int i=0;i<topK;i++){
    	     int max = countCombinThree.get(0);
    	     int maxIndex = 0;
    	     for(int j=1;j<countCombinThree.size();j++){
    		     if(countCombinThree.get(j) > max){
    		 	   max = countCombinThree.get(j);
    			   maxIndex = j;
    		    }
    	     }
		     topK1.add(combinThree1.get(maxIndex));
		     topKIndex1.add(combin3Index1.get(maxIndex));
		     topK2.add(combinThree2.get(maxIndex));
		     topKIndex2.add(combin3Index2.get(maxIndex));
		     topK3.add(combinThree3.get(maxIndex));
		     topKIndex3.add(combin3Index3.get(maxIndex));
		     topKCount.add(countCombinThree.get(maxIndex));
		      // remove max element
		     combinThree1.remove(maxIndex);
		     combin3Index1.remove(maxIndex);
		     combinThree2.remove(maxIndex);
		     combin3Index2.remove(maxIndex);
		     combinThree3.remove(maxIndex);
		     combin3Index3.remove(maxIndex);
		     countCombinThree.remove(maxIndex);
          }
        break;
      }
      case 4:{
          CombinFour();
          for(int i=0;i<topK;i++){
    	     int max = countCombinFour.get(0);
    	     int maxIndex = 0;
    	     for(int j=1;j<countCombinFour.size();j++){
    		     if(countCombinFour.get(j) > max){
    		 	   max = countCombinFour.get(j);
    			   maxIndex = j;
    		    }
    	     }
		     topK1.add(combinFour1.get(maxIndex));
		     topKIndex1.add(combin4Index1.get(maxIndex));
		     topK2.add(combinFour2.get(maxIndex));
		     topKIndex2.add(combin4Index2.get(maxIndex));
		     topK3.add(combinFour3.get(maxIndex));
		     topKIndex3.add(combin4Index3.get(maxIndex));
		     topK4.add(combinFour4.get(maxIndex));
		     topKIndex4.add(combin4Index4.get(maxIndex));
		     topKCount.add(countCombinFour.get(maxIndex));
		      // remove max element
		     combinFour1.remove(maxIndex);
		     combin4Index1.remove(maxIndex);
		     combinFour2.remove(maxIndex);
		     combin4Index2.remove(maxIndex);
		     combinFour3.remove(maxIndex);
		     combin4Index3.remove(maxIndex);
		     combinFour4.remove(maxIndex);
		     combin4Index4.remove(maxIndex);
		     countCombinFour.remove(maxIndex);
          }
        break;
      } 
     }
       // output to output.txt 
     try{ 
       PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));
       switch(combination){
        case 2:{
           for(int i=0;i<topK1.size();i++){
        	   for(int j=0;j<objName.length;j++){
        		  if(topKIndex1.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	   }
      	       writer.print(topK1.get(i)+",");
        	   for(int j=0;j<objName.length;j++){
        		  if(topKIndex2.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	   }
    	       writer.println(topK2.get(i)+";"+topKCount.get(i));
           }
           break;
        }
        case 3:{
            for(int i=0;i<topK1.size();i++){
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex1.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
        	    writer.print(topK1.get(i)+",");
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex2.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
      	        writer.print(topK2.get(i)+",");
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex3.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
      	        writer.println(topK3.get(i)+";"+topKCount.get(i));
             }
             break;
        }
        case 4:{
            for(int i=0;i<topK1.size();i++){
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex1.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
  	            writer.print(topK1.get(i)+",");
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex2.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
	            writer.print(topK2.get(i)+",");
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex3.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
	            writer.print(topK3.get(i)+",");
        	    for(int j=0;j<objName.length;j++){
        		  if(topKIndex4.get(i).equals(j))
        			  writer.print(objName[j].substring(1,objName[j].length()-1)+":");
        	    }
	            writer.println(topK4.get(i)+";"+topKCount.get(i));
             }
             break;
         }
       }
		writer.flush();
		writer.close();
     }catch(Exception e){
    	 e.printStackTrace();
      }
    }
	
	public static void CombinTwo(){
		
		for(int i=0;i<objName.length;i++){
			for(int j=i+1;j<objName.length;j++){
				ArrayList<String> first = new ArrayList<String>();
				ArrayList<String> second = new ArrayList<String>();
				int[] sameCount = new int[jsondata.length()];
				
				for(int r=0;r<objName.length;r++){
					if(i == r){
						for(int k=0;k<jsondata.length();k++)
						    first.add(getJSONObj[r].get(k));
					}
				}

				for(int r=0;r<objName.length;r++){
					if(j == r){
						for(int k=0;k<jsondata.length();k++)
						    second.add(getJSONObj[r].get(k));
					}
				}
				  // initialize 
				for(int l=0;l<sameCount.length;l++)
					sameCount[l] = 0;
				
				for(int m=0;m<jsondata.length();m++){
				    for(int n=0;n<jsondata.length();n++){
					    if(first.get(m).equals(first.get(n)) && second.get(m).equals(second.get(n)))
					    	sameCount[m]++;
				    }
				    if(sameCount[m] >= 20){
				        if(combinTwo1.size()==0){
				           combinTwo1.add(first.get(m));
				           combin2Index1.add(i);
				           combinTwo2.add(second.get(m));
				           combin2Index2.add(j); 
				           countCombinTwo.add(sameCount[m]);
				        }
				        if(combinTwo1.size()>=1){
				        	int diff = 1;
				        	for(int o=0;o<combinTwo1.size();o++){
				        		if(!(combinTwo1.get(o).equals(first.get(m)) && combinTwo2.get(o).equals(second.get(m)) ))
				        			diff *= 1;
				        		else
				        			diff *= 0;
				        	}	
				        	if(diff == 1){
						         combinTwo1.add(first.get(m));
						         combin2Index1.add(i);
						         combinTwo2.add(second.get(m));
						         combin2Index2.add(j); 
						         countCombinTwo.add(sameCount[m]);
				        	}	
				        }
				    }
               }
				
			}
		}
			
	}
	
	public static void CombinThree(){
		
		for(int i=0;i<objName.length;i++){
			for(int j=i+1;j<objName.length;j++){
				for(int p=j+1;p<objName.length;p++){
				ArrayList<String> first = new ArrayList<String>();
				ArrayList<String> second = new ArrayList<String>();
				ArrayList<String> third = new ArrayList<String>();
				int[] sameCount = new int[jsondata.length()];
				
				for(int r=0;r<objName.length;r++){
					if(i == r){
						for(int k=0;k<jsondata.length();k++)
						    first.add(getJSONObj[r].get(k));
					}
				}

				for(int r=0;r<objName.length;r++){
					if(j == r){
						for(int k=0;k<jsondata.length();k++)
						    second.add(getJSONObj[r].get(k));
					}
				}
				
				for(int r=0;r<objName.length;r++){
					if(p == r){
						for(int k=0;k<jsondata.length();k++)
						    third.add(getJSONObj[r].get(k));
					}
				}
				  // initialize 
				for(int l=0;l<sameCount.length;l++)
					sameCount[l] = 0;
				
				for(int m=0;m<jsondata.length();m++){
				    for(int n=0;n<jsondata.length();n++){
					    if(first.get(m).equals(first.get(n)) && second.get(m).equals(second.get(n)) && third.get(m).equals(third.get(n)))
					    	sameCount[m]++;
				    }
				    if(sameCount[m] >= 20){
				        if(combinThree1.size()==0){
				           combinThree1.add(first.get(m));
				           combin3Index1.add(i);
				           combinThree2.add(second.get(m));
				           combin3Index2.add(j);
				           combinThree3.add(third.get(m));
				           combin3Index3.add(p);
				           countCombinThree.add(sameCount[m]);
				        }
				        if(combinThree1.size()>=1){
				        	int diff = 1;
				        	for(int o=0;o<combinThree1.size();o++){
				        		if(!(combinThree1.get(o).equals(first.get(m)) && combinThree2.get(o).equals(second.get(m)) && combinThree3.get(o).equals(third.get(m)) ))
				        			diff *= 1;
				        		else
				        			diff *= 0;
				        	}	
				        	if(diff == 1){
						         combinThree1.add(first.get(m));
						         combin3Index1.add(i);
						         combinThree2.add(second.get(m));
						         combin3Index2.add(j);
						         combinThree3.add(third.get(m));
						         combin3Index3.add(p);
						         countCombinThree.add(sameCount[m]);
				        	}	
				        }
				    }
               }
		    }  
		  }
		 }	
	   }
		
		public static void CombinFour(){
			
			for(int i=0;i<objName.length;i++){
			  for(int j=i+1;j<objName.length;j++){
				for(int p=j+1;p<objName.length;p++){
				  for(int q=p+1;q<objName.length;q++){	
					ArrayList<String> first = new ArrayList<String>();
					ArrayList<String> second = new ArrayList<String>();
					ArrayList<String> third = new ArrayList<String>();
					ArrayList<String> four = new ArrayList<String>();
					int[] sameCount = new int[jsondata.length()];

					for(int r=0;r<objName.length;r++){
						if(i == r){
							for(int k=0;k<jsondata.length();k++)
							    first.add(getJSONObj[r].get(k));
						}
					}

					for(int r=0;r<objName.length;r++){
						if(j == r){
							for(int k=0;k<jsondata.length();k++)
							    second.add(getJSONObj[r].get(k));
						}
					}
					
					for(int r=0;r<objName.length;r++){
						if(p == r){
							for(int k=0;k<jsondata.length();k++)
							    third.add(getJSONObj[r].get(k));
						}
					}
					
					for(int r=0;r<objName.length;r++){
						if(q == r){
							for(int k=0;k<jsondata.length();k++)
							    four.add(getJSONObj[r].get(k));
						}
					}
					  // initialize 
					for(int l=0;l<sameCount.length;l++)
						sameCount[l] = 0;
					
					for(int m=0;m<jsondata.length();m++){
					    for(int n=0;n<jsondata.length();n++){
						    if(first.get(m).equals(first.get(n)) && second.get(m).equals(second.get(n)) && third.get(m).equals(third.get(n)) && four.get(m).equals(four.get(n)))
						    	sameCount[m]++;
					    }
					    if(sameCount[m] >= 0){
					        if(combinFour1.size()==0){
					           combinFour1.add(first.get(m));
					           combin4Index1.add(i);
					           combinFour2.add(second.get(m));
					           combin4Index2.add(j);
					           combinFour3.add(third.get(m));
					           combin4Index3.add(p);
					           combinFour4.add(four.get(m));
					           combin4Index4.add(q);
					           countCombinFour.add(sameCount[m]);
					        }
					        if(combinFour1.size()>=1){
					        	int diff = 1;
					        	for(int o=0;o<combinFour1.size();o++){
					        		if(!(combinFour1.get(o).equals(first.get(m)) && combinFour2.get(o).equals(second.get(m)) && combinFour3.get(o).equals(third.get(m)) && combinFour4.get(o).equals(four.get(m)) ))
					        			diff *= 1;
					        		else
					        			diff *= 0;
					        	}	
					        	if(diff == 1){
							         combinFour1.add(first.get(m));
							         combin4Index1.add(i);
							         combinFour2.add(second.get(m));
							         combin4Index2.add(j);
							         combinFour3.add(third.get(m));
							         combin4Index3.add(p);
							         combinFour4.add(four.get(m));
							         combin4Index4.add(q);
							         countCombinFour.add(sameCount[m]);
					        	}	
					        }
					    }
	          }
			    }	
			  }  
			}
		  }
	  		
	}
	
}

