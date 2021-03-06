����   4 w
  q r s
  t u v inCheck Z 
Deprecated RuntimeVisibleAnnotations Ljava/lang/Deprecated; <init> ()V Code LineNumberTable LocalVariableTable this Ljava/lang/SecurityManager; 
getInCheck ()Z getClassContext ()[Ljava/lang/Class; currentClassLoader ()Ljava/lang/ClassLoader; currentLoadedClass ()Ljava/lang/Class; 	Signature ()Ljava/lang/Class<*>; 
classDepth (Ljava/lang/String;)I name Ljava/lang/String; classLoaderDepth ()I inClass (Ljava/lang/String;)Z inClassLoader getSecurityContext ()Ljava/lang/Object; checkPermission (Ljava/security/Permission;)V perm Ljava/security/Permission; /(Ljava/security/Permission;Ljava/lang/Object;)V context Ljava/lang/Object; checkCreateClassLoader checkAccess (Ljava/lang/Thread;)V t Ljava/lang/Thread; (Ljava/lang/ThreadGroup;)V g Ljava/lang/ThreadGroup; 	checkExit (I)V status I 	checkExec (Ljava/lang/String;)V cmd 	checkLink lib 	checkRead (Ljava/io/FileDescriptor;)V fd Ljava/io/FileDescriptor; file '(Ljava/lang/String;Ljava/lang/Object;)V 
checkWrite checkDelete checkConnect (Ljava/lang/String;I)V host port ((Ljava/lang/String;ILjava/lang/Object;)V checkListen checkAccept checkMulticast (Ljava/net/InetAddress;)V maddr Ljava/net/InetAddress; (Ljava/net/InetAddress;B)V ttl B checkPropertiesAccess checkPropertyAccess key checkTopLevelWindow (Ljava/lang/Object;)Z window checkPrintJobAccess checkSystemClipboardAccess checkAwtEventQueueAccess checkPackageAccess pkg checkPackageDefinition checkSetFactory checkMemberAccess (Ljava/lang/Class;I)V clazz Ljava/lang/Class; which LocalVariableTypeTable Ljava/lang/Class<*>; (Ljava/lang/Class<*>;I)V checkSecurityAccess target getThreadGroup ()Ljava/lang/ThreadGroup; 
SourceFile SecurityManager.java   java/lang/RuntimeException Stub!  < java/lang/SecurityManager java/lang/Object !          	     
        *        8     *� � Y� �           -                    4     
� Y� �           3        
     	     
               4     
� Y� �           5        
       