package de.wbstraining.ocp.nio;
public class UserPrincipalDemo {
public static void main(String[] args) throws IOException {
String s = "src/wbs/nio/misc/FileStoreDemo.java";
Path path = Paths.get(s);
UserPrincipalLookupService lookupService =
FileSystems.getDefault()
.getUserPrincipalLookupService();
UserPrincipal userPrincipal =
lookupService.lookupPrincipalByName("gz1");
System.out.println(userPrincipal);
userPrincipal = Files.getOwner(path);
System.out.println(userPrincipal);
try {
Files.setOwner(path,
lookupService.lookupPrincipalByName("gz2"));
}
catch(UserPrincipalNotFoundException e) {
e.printStackTrace();
}
}
}