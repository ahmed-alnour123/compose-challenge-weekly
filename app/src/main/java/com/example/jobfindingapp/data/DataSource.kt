package com.example.jobfindingapp.data

import com.example.jobfindingapp.R
import com.example.jobfindingapp.models.Job

class DataSource {
    companion object {
        val jobsList: List<Job> = listOf(
            Job(
                title = "Swift Developer",
                city = "Delhi",
                town = "New Delhi",
                postedDate = "2 days ago",
                jobTime = "Full time",
                rating = "4.5",
                salary = "\$10 k",
                companyName = "Infosys",
                aboutCompany = "",
                aboutJob = "Infosys Limited is an Indian multinational informa-tion technology company that provides business consulting, information technology and outsource services.",
                description = "We are looking for a C# developer to build software using languages, technologies of the .NET framework. \n" +
                        "\n" +
                        "You will create applications from scratch, configure existing systems and provide user support.Must have Potential to design, develop program independently.\n" +
                        "\n" +
                        "      ",
                icon = R.drawable.ic_swift_icon,
            ),
            Job(
                title = "C Sharp Developer",
                city = "Gurugram",
                town = "Haryana",
                postedDate = "2 days ago",
                jobTime = "Full time",
                rating = "4.5",
                salary = "\$10 k",
                companyName = "Infosys",
                aboutCompany = "",
                aboutJob = "Infosys Limited is an Indian multinational informa-tion technology company that provides business consulting, information technology and outsource services.",
                description = "We are looking for a C# developer to build software using languages, technologies of the .NET framework. \n" +
                        "\n" +
                        "You will create applications from scratch, configure existing systems and provide user support.Must have Potential to design, develop program independently.\n" +
                        "\n" +
                        "      ",
                icon = R.drawable.ic_c_sharp_icon,
            )
        )
    }
}
