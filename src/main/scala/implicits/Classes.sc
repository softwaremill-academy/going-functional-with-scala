implicit class ExtraStringMethods(val s: String) {
  private val vowels = Seq('a', 'e', 'i', 'o', 'u')
  //add number of vowels method

  def dejMiSamogloski = s.count(vowels contains _)
}

new ExtraStringMethods("Softwaremill").dejMiSamogloski

"Softwaremill".dejMiSamogloski
