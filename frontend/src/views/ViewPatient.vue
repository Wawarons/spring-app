<template>
  <main>
    <NavBar />

    <!-- Table  -->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">View Patients</h1>
          <a href="/add" class="btn btn-primary">Add patients</a>
          <table class="table table-stripped">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="patient in patients" :key="patient.id">
                <th scope="row">{{ patient.id }}</th>
                <td>{{ patient.name }}</td>
                <td>{{ patient.email }}</td>
                <td>{{ patient.pno }}</td>
                <td>{{ patient.gender }}</td>

                <td>
                  <a class="btn btn-primary" :href="`/edit/${patient.id}`"
                    >Edit</a
                  >
                  <button
                    class="btn btn-danger mx-2"
                    @click="($event) => deletePatient(patient.id)"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import { onBeforeMount } from "vue";

export default {
  components: {
    NavBar,
  },

  data() {
    return {
      patients: [],
    };
  },

  methods: {
    getPatient() {
      fetch("https://localhost:8080/patients")
        .then((res) => res.json)
        .then((data) => {
          this.patients = data;
          console.log(data);
        });
    },

    deletePatient(id) {
      fetch(`http://localhost:8080/patient/${id}`, {
        method: "DELETE",
      }).then((data) => {
        console.log(data);
        this.getPatients();
      });
    },
  },

  onBeforeMount() {
    getPatient();
  },
};
</script>
