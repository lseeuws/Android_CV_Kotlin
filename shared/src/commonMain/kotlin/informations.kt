data class informations(
    val experience: String = "Expériences professionnel",

    val experienceText: String = "Stagiaire administrateur réseau (L3i) :\n" +
            "-installation de matériels\n" +
            "-Maintenance matériels (imprimante, poste, ...)\n" +
            "-Veille au bon fonctionnement du réseau\n" +
            "Stagiaire développeur web (Jocaflor) :\n" +
            "-Création de sites avec le CMS Wordpress\n" +
            "-Ajout de fonctionnalités pour les sites en JavaScript (HTML/CSS)\n" +
            "-Maintenance serveur\n" +
            "-Gestion de base de données\n" +
            "4 semaines de stage\n" +
            "3 mois de stage",

    val formation: String = "formation",

    val formationList: String =
    "BACHELOR FORMATION DEVELOPPEUR FULL STACK\n" +
        "Lycée Frederic Ozanam Lille 2019-2021\n" +
        "BTS SYSTÈME NUMÉRIQUE INFORMATIQUE ET RÉSEAUX\n"+
        "Lycée Frederic Ozanam Lille 2019-2021\n" +
        "BACCALAURÉAT SCIENTIFIQUE OPTION INFORMATIQUE" +
        "Lycée Privé Notre-Dame-de la Paix, Lille 2017 – 2019",


//    val formationList: List<String> = listOf(
//        "BACHELOR FORMATION DEVELOPPEUR FULL STACK\n",
//        "BTS SYSTÈME NUMÉRIQUE INFORMATIQUE ET RÉSEAUX\n",
//        "BACCALAURÉAT SCIENTIFIQUE OPTION INFORMATIQUE",
//    ),

    val formationDateEtablissement: List<String> = listOf(
        "EFFICOM Tech School Lille 2021-2022\n",
        "Lycée Frederic Ozanam Lille 2019-2021\n",
        "Lycée Privé Notre-Dame-de la Paix, Lille 2017 – 2019\n"
    ),

    val competence: String = "Stacks Techniques",

    val competenceText: List<Pair<String, Int>> = listOf(
        "HTML/CSS" to 5,
        "NodeJs" to 4,
        "SQL/Postgres" to 3,
        "JavaScript" to 4,
        "Express" to 3,
        "Mysql/PostgreSQL" to 3,
        "C#/C++" to 2,
        "React" to 4,
        "PHP" to 3,
        "Shell/PowerShell" to 2,
        "Wordpress/Prestashop" to 1,
        "Kotlin" to 4
    ),

    val competenceLangue: String = "Langues",

    val languagesCompetence: List<Pair<String, Int>> = listOf(
            "Français" to 5,
            "Anglais" to 3,
            "Espagnol" to 1,
    ),

    val project: String = "Projet scolaire",

    val projectText: String = "Station météo connectée :\n" +
            "-Récupérer les données transmises par la station\n" +
            "-Décoder les trames\n" +
            "-Création et gestion d'une base de données\n" +
            "-Création d'un site web en lien avec la base de données",
)

