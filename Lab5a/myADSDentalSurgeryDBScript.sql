
-- Display the list of ALL Dentists registered in the system, 
-- sorted in ascending order of their lastNames 

Select u.id,u.firstName,u.lastName,u.phoneNumber,u.email,u.specialization from User u inner join User_Role ur on ur.userId = u.id 
inner join role r on r.roleId = ur.roleId  where r.roleId = 1 order by u.lastname asc;

-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number.
-- Include in the result, the Patient information. 


Select u.id,u.firstName as "D FirstName" ,u.lastName as "D LastName",
	a.appointmentId ,a.appointmentDateTime,
		p.firstName as "P FirstName",p.lastName as "P LastName",p.phoneNumber,p.email,p.dob ,ad.state,ad.city from User u inner join User_Role ur on ur.userId = u.id 
inner join role r on r.roleId = ur.roleId  
right join appointment a  on a.doctorId = u.id
inner join User p on p.id = a.patientId
inner join Address ad on ad.addressId = p.addressId
where  r.roleId = 1 ;

-- Display the list of ALL Appointments that have been scheduled at a Surgery Location 
select a.appointmentId ,a.appointmentDateTime,sl.location from appointment a
	inner join surgery s on a.sid = s.sid
		inner join surgeryLocation sl on sl.slid = s.slid 
        where sl.slid = 1;
        
-- Display the list of the Appointments booked for a given Patient on a given Date. 
select a.appointmentId ,a.appointmentDateTime,p.firstname  from appointment a
	inner join User p on a.patientId = p.id
        where p.id = 2 and 
        DATE(a.appointmentDateTime) = '2024-04-07' ;



