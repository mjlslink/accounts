Spring Boot Auditor Module
=========================== 
This module provides auditing capabilities for the AccountsT application, allowing you to track 
and log changes made to entities within the system. It leverages Spring Boot's auditing features 
to automatically capture and store audit information.
Getting Started
-------------------
To use the Auditor module, follow these steps:
1. Add the Auditor module as a dependency in your project's build configuration (e.g., Maven or Gradle).
2. Enable auditing in your Spring Boot application by adding the @EnableJpaAuditing annotation to
   your main application class.
3. Configure the AuditorAware bean to provide the current user information for auditing purposes.
4. Annotate the entities you want to audit with @CreatedBy, @CreatedDate, @LastModifiedBy, and 
   @LastModifiedDate annotations.
5. Run your application, and the auditing information will be automatically captured and stored
   in the database.
Configuration
-------------------
The Auditor module can be configured using the following properties in your application.properties
or application.yml file:
- auditor.enabled: Enable or disable the auditing functionality (default: true).
- auditor.date-format: Specify the date format for audit timestamps (default: yyyy-MM-dd HH:mm:ss).
- auditor.user-provider: Define the bean name of the AuditorAware implementation to use for
  retrieving the current user (default: auditorAware).
Customization
-------------------
You can customize the Auditor module by implementing your own AuditorAware interface to provide
the current user information. This allows you to integrate with your existing authentication
mechanism.
You can also extend the auditing functionality by creating custom annotations or listeners to
capture additional audit information specific to your application's requirements.
License
-------------------
This project is licensed under the MIT License. See the LICENSE file for details.