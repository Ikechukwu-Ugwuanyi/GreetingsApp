package com.example.lessonreviews

 class Datasource {
     fun loadAffirmations() : List<Affirmations>{
         return listOf<Affirmations>(
             Affirmations(R.string.affirmation1, R.drawable.image1),
             Affirmations(R.string.affirmation1, R.drawable.image2),
             Affirmations(R.string.affirmation1, R.drawable.image3),
             Affirmations(R.string.affirmation1, R.drawable.image4),
             Affirmations(R.string.affirmation1, R.drawable.image5),
             Affirmations(R.string.affirmation1, R.drawable.image6),
             Affirmations(R.string.affirmation1, R.drawable.image7),
             Affirmations(R.string.affirmation1, R.drawable.image8),
             Affirmations(R.string.affirmation1, R.drawable.image9),
             Affirmations(R.string.affirmation1, R.drawable.image10),
         )

     }
 }
