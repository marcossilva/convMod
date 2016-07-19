# Talk Tracker

##Main Objective
Isn’t it disturbing when people start to cut you off in a conversation? Wouldn’t be good if managers could have a tool 
keep tracking tons of presentations they need to watch? What about developing a tool to support Speech Pathologists in 
detecting and treating common speech disorders? Having those thoughts in mind we have decided to build a tool in our 
time at the CS Summer Program Research at Loyola University. For practical reasons we choose to build an Android application.

##Tools
This issue relates to a certain topic in the speech recognition study: Speaker Diarization. This subject focus in answer 
the question Who spoke when?. In order to solve this problem, we need to track the segments of time in which a speaker spoke.
The tool utilizes a speech recognizing library written in Java called LIUM Speaker Diarization toolkit that analyzes a audio 
recording file and separates the segments of speech present in the audio, then associates these segments to each speaker.

The LIUM library uses certain techniques used in Machine Learning algorithms as Clustering and Hidden Markov Models (HMM).
The Android Studio was used to develop the main core of the application because it is the tool suggested by Google. The 
installation steps can be found at https://developer.android.com/studio/index.html

Each activity is like a new screen of the application. We created the splash screen that implies the legal implications of 
recording voice and warns the user that it might be illegal in some places.
We have the main screen where the user can record the conversation and after the recording the statistics of the 
conversation as the list of speakers identified and how long each one spoke as well as a pie chart displaying the percentage 
of speaking time each speaker had.
 
## Thanks
We would like to thank the Loyola University for this amazing opportunity, the CAPES for the funding through the BSMP program represented by IIE. We would like to thank the Professor Mark Albert for the amazing support.
